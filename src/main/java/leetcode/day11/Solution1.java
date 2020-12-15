package leetcode.day11;

/**
 * @Author: zhangyh
 * @ClassName: Solution1
 * @Date: 2020/12/14 20:42
 * @Operation:
 * @Description:
 *
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1 {


    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] a = new int[]{2,3,1,3,3};
        solution.nextPermutation(a);
        for(int i : a){
            System.out.println(i);
        }
    }

    /**
     * 如何得到这样的排列顺序？这是本文的重点。我们可以这样来分析：
     *
     * 我们希望下一个数比当前数大，这样才满足“下一个排列”的定义。因此只需要将后面的「大数」与前面的「小数」交换，就能得到一个更大的数。比如 123456，将 5 和 6 交换就能得到一个更大的数 123465。
     * 我们还希望下一个数增加的幅度尽可能的小，这样才满足“下一个排列与当前排列紧邻“的要求。为了满足这个要求，我们需要：
     * 在尽可能靠右的低位进行交换，需要从后向前查找
     * 将一个 尽可能小的「大数」 与前面的「小数」交换。比如 123465，下一个排列应该把 5 和 4 交换而不是把 6 和 4 交换
     * 将「大数」换到前面后，需要将「大数」后面的所有数重置为升序，升序排列就是最小的排列。以 123465 为例：首先按照上一步，交换 5 和 4，得到 123564；然后需要将 5 之后的数重置为升序，得到 123546。显然 123546 比 123564 更小，123546 就是 123465 的下一个排列
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }
        Integer index = null;
        for (int i = nums.length-2;i >= 0;i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }

        }
        if(index != null) {
            int min = index + 1;
            for (int i = index + 2; i < nums.length; i++) {
                if (nums[i] >= nums[index] && nums[i] <= nums[min]) {
                    min = i;
                }
            }
            swap(index, min, nums);
            int mid = (index+1+nums.length)/2;
            for (int i = 0;index+i+1 < mid;i++){
                swap(index+i+1,nums.length-1-i,nums);
            }
        }else {
            int mid = (nums.length)/2;
            for (int i = 0;i < mid;i++){
                swap(i,nums.length-1-i,nums);
            }
        }

    }




    public void swap(int left,int right,int[] nums){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
