package leetcode.day12;

/**
 * @Author: zhangyh
 * @ClassName: Solution7
 * @Date: 2020/12/21 14:39
 * @Operation:
 * @Description:
 *
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution7 {

    public static void main(String[] args) {
        Solution7 solution = new Solution7();
        int[] a = new int[]{2,3,1,1,4};
        System.out.println(solution.canJump(a));
    }


    /**
     * 假设每个位置能跳的最远点k（如果k大于等于len-1，则直接返回）
     * i~k 所有点能作为起跳的，每次都有更新最远点k
     * 直到跳完
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2){
            return true;
        }
        int k = nums[0];
        for (int i = 1; i < nums.length;i++){
            //i位置不能到达
            if(k >= nums.length - 1){
                return true;
            }
            if(i > k){
                return false;
            }
            k = Math.max(k,i+nums[i]);
        }
        return false;
    }


    /**
     * dp[i] == 1 表示 前面有位置可以跳到 i
     * dp[i] == 0 表示 前面有位置不可以跳到 i
     *
     * 从0开始跳，记录0可以调到的位置，
     * i如果==1，则记录从i开始能跳到位置
     * 知道有值==length
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        if(nums == null || nums.length < 2){
            return true;
        }
        int[] dp = new int[nums.length];
        //记录开始能跳到的所有点
        int target = nums.length - 1;
        for (int j = 1;j <= nums[0];j++){
            if(j < target){
                dp[j] = 1;
            }else if(j == target){
                return true;
            }
        }

        for (int i = 1;i < nums.length ;i++){
            if(dp[i] == 1){
                if(nums[i] + i >= target){
                    return true;
                }
                for (int j = 1;j <= nums[i];j++){
                    if(i+j < target){
                        dp[i+j] = 1;
                    }
                }
            }
        }

        return false;
    }
}
