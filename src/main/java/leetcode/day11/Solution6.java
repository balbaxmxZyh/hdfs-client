package leetcode.day11;

/**
 * @Author: zhangyh
 * @ClassName: Solution6
 * @Date: 2020/12/18 17:14
 * @Operation:
 * @Description:
 *
 * 1480. 一维数组的动态和
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 *
 * 请返回 nums 的动态和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 * 示例 2：
 *
 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 *
 *
 * https://leetcode-cn.com/problems/running-sum-of-1d-array/
 */
public class Solution6 {

    public static void main(String[] args) {
        Solution6 solution = new Solution6();
        int[] a = new int[]{1,2,3,4,5,6};
        int[] k = solution.runningSum(a);
        for (int i : k){
            System.out.println(i);
        }
    }

    /**
     * dp[i] 表示nums[0]+nums[1]+...nums[i]的和
     * dp[i+1] = dp[i]+muns[i+1]
     * @param nums
     * @return
     */
    public int[] runningSum(int[] nums) {
        if(nums == null || nums.length  < 2){
            return nums;
        }

        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1;i < nums.length;i++){
            result[i] = result[i-1]+nums[i];
        }

        return result;
    }
}
