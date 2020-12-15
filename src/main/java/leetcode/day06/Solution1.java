package leetcode.day06;

/**
 * @Author: zhangyh
 * @ClassName: Solution1
 * @Date: 2020/11/22 12:34
 * @Operation:
 * @Description:
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] a = new int[]{-3,-2,-5,3,-4};
        int target = -1;
        System.out.println(solution.threeSumClosest(a,target));
    }


    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3){
            return 0;
        }
        //排序
        quickSort(nums,0,nums.length - 1);
        int min = 100000;
        for (int i = 0;i < nums.length -2;i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int a = nums[i];
            int left = i+1;
            int right = nums.length-1;
            while (left <right){
                int b = nums[left];
                int c = nums[right];
                if(a + b +c == target){
                    return target;
                }else {
                   if(Math.abs(target-(a+b+c)) < Math.abs(target-min)){
                       min = a+b+c;
                   }

                   if(target > a + b +c){
                        //是结果是负数，总数多加，left往上加
                         left++;
                         //去掉重复的值
                       while (left < right && nums[left] == nums[left - 1]) {
                           left++;
                       }
                   }else {
                       //是结果是正数，总数多减，right往下减
                       right--;
                       //去掉重复的值
                       while (left < right && nums[right] == nums[right + 1]) {
                           right--;
                       }
                   }
                } {
                 
                }
            }

        }
        
        return min;
    }

    public void quickSort(int[] a,int left,int right){
        if(left < right){
            int mid = compare(a,left,right);
            quickSort(a,left,mid -1);
            quickSort(a,mid+1,right);
        }
    }

    public int compare(int[] a,int left,int right){

        int pop = a[left];
        while (left < right){
            while (left < right && a[right] >= pop){
                right--;
            }
            a[left] = a[right];

            while (left < right && a[left] <= pop){
                left++;
            }
            a[right] = a[left];
        }
        a[left] = pop;
        return left;
    }
}
