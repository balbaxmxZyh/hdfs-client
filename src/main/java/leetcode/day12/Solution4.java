package leetcode.day12;

/**
 * @Author: zhangyh
 * @ClassName: Solution4
 * @Date: 2020/12/21 13:52
 * @Operation:
 * @Description:
 *
 *
 * 给你一个整数数组 nums 。
 *
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 *
 * 返回好数对的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1,1,3]
 * 输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 * 示例 2：
 *
 * 输入：nums = [1,1,1,1]
 * 输出：6
 * 解释：数组中的每组数字都是好数对
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-good-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution4 {

    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        int[] str = new int[]{1,2,3,1,1,3};
        System.out.println(solution.numIdenticalPairs(str));
    }


    /**
     * 遍历就行
     * @param nums
     * @return
     */
    public int numIdenticalPairs(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        int total = 0;
        for (int i = 0 ;i < nums.length - 1 ;i++){
            for (int j = i+1;j < nums.length;j++){
                if(nums[i] == nums[j]){
                    total++;
                }
            }
        }
        return total;
    }
}
