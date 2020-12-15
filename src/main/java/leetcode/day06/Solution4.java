package leetcode.day06;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangyh
 * @ClassName: Solution4
 * @Date: 2020/11/22 20:52
 * @Operation:
 * @Description:
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution4 {

    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        int[] nums = new int[]{-2,-1,-1,1,1,2,2};
        //-2,-1,0,0,1,2
        int target = 0;
        System.out.println(solution.fourSum(nums,target));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length < 4){
            return list;
        }

        insertSort(nums,0,nums.length - 1);

        int len = nums.length;
        for (int i = 0 ;i < len - 3;i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int val1 = nums[i];
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i+1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int val2 = nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int result = val1 + val2 + nums[left] + nums[right];
                    if (result == target) {
                        List<Integer> l = new ArrayList<>(4);
                        l.add(val1);
                        l.add(val2);
                        l.add(nums[left]);
                        l.add(nums[right]);
                        list.add(l);
                        left++;
                        right--;
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                    } else if (result > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return list;
    }

    public void insertSort(int[] a ,int left,int right){
        if(left < right){
            int mid = compare(a,left,right);
            insertSort(a,left,mid - 1);
            insertSort(a,mid + 1,right);
        }
    }

    public int compare(int[] a ,int left,int right){
        int pro = a[left];
        while(left < right){
            while (left < right && a[right] >= pro){
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] <= pro){
                left++;
            }
            a[right] = a[left];
        }
        a[left] = pro;
        return left;
    }

}
