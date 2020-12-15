package leetcode.day09;

/**
 * @Author: zhangyh
 * @ClassName: Solution1
 * @Date: 2020/12/4 11:08
 * @Operation:
 * @Description:
 *
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *  
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] a = new int[]{1,1,1,2,2,3,4};
        System.out.println(solution.removeDuplicates2(a));
    }


    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int sum = 0;
        int del = 0;
        for (int i = 0 ;i < nums.length ;){
            if( nums.length - i - 1 < del){
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                del++;
                for (int j = i ;j < nums.length-del ;j++){
                    nums[j] = nums[j+1];
                }
                continue;
            }
            i++;
            sum++;
        }

        return sum;
    }


    /**
     * 双指针思想
     *
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int slow = 0;
        int quick = 1;
        int sum = 1;
        while (quick < nums.length){
            if(nums[slow] == nums[quick]){
                quick++;
            }else {
                sum++;
                nums[++slow] = nums[quick];
            }
        }

        return sum;
    }


    public void quickSort(int left,int right,int[] a){

        if(left < right){
            int mid = compare(left,right,a);
            quickSort(left,mid-1,a);
            quickSort(mid+1,right,a);
        }

    }

    public int compare(int left,int right,int[] a){
        int mid = a[left];
        while (left < right){

            while (left < right && a[right] >= mid){
                right--;
            }
            a[left] = a[right];

            while (left < right && a[left] <= mid){
                left++;
            }
            a[right] = a[left];

        }
        a[left] = mid;


        return left;
    }

}
