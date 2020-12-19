package leetcode.day11;

/**
 * @Author: zhangyh
 * @ClassName: Solution4
 * @Date: 2020/12/18 15:58
 * @Operation:
 * @Description:
 *
 *
输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

要求时间复杂度为O(n)。



示例1:

输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。


https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
public class Solution4 {

    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        int[] a = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution.maxSubArray2(a));
    }

    /**
     * dp[i]标识下标i的最大和
     *
     * dp[i] = MAX(dp[i-1]+nums[i],nums[i]);
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length == 0){
            return 0;
        }
        int[] len = new int[nums.length];
        len[0] = nums[0];
        int max = nums[0];
        for (int i = 1;i < nums.length;i++){
            if(nums[i] + len[i-1] < nums[i]){
                len[i] = nums[i];
            }else {
                len[i] = len[i-1] +  nums[i];
            }
            max = Math.max(max,len[i]);

        }
        return max;
    }


    public int maxSubArray2(int[] nums) {
        if(nums==null || nums.length == 0){
            return 0;
        }
        int max = nums[0];
        int pre = nums[0];
        for (int i = 1;i < nums.length;i++){
            int concurrent ;
            if(nums[i] + pre < nums[i]){
                concurrent = nums[i];
            }else {
                concurrent = pre +  nums[i];
            }
            max = Math.max(max,concurrent);
            pre = concurrent;
        }
        return max;
    }
}
