package leetcode.day12;

/**
 * @Author: zhangyh
 * @ClassName: Solution8
 * @Date: 2020/12/21 15:31
 * @Operation:
 * @Description:
 *
 * 给你两个整数，n 和 start 。
 *
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 *
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 5, start = 0
 * 输出：8
 * 解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
 *      "^" 为按位异或 XOR 运算符。
 * 示例 2：
 *
 * 输入：n = 4, start = 3
 * 输出：8
 * 解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xor-operation-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution8 {

    public static void main(String[] args) {
        Solution8 solution = new Solution8();
        System.out.println(solution.xorOperation(5,4));
    }


    public int xorOperation(int n, int start) {
        if(n <= 0){
            return 0;
        }
        int result  = start;
        for (int i = 1 ;i < n;i++){
            result = result ^ (start+=2);
        }
        return result;
    }
}
