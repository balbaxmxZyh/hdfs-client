package leetcode.day09;

/**
 * @Author: zhangyh
 * @ClassName: Solution2
 * @Date: 2020/12/4 14:40
 * @Operation:
 * @Description:
 *
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 给定 nums = [3,2,2,3], val = 3,
 *
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] a = new int[]{1,2,3,2,2,5,3};
        System.out.println(solution.removeElement(a,2));
    }


    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length < 1){
            return 0;
        }

        int quick = 0;
        int slow = 0;
        int sum = nums.length;
        while (quick < nums.length){
            if(nums[quick] != val){
                nums[slow++] = nums[quick++];
            }else {
                sum--;
                quick++;
            }
        }

        return sum;
    }
}
