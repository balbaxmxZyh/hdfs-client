package leetcode.day12;

/**
 * @Author: zhangyh
 * @ClassName: Solution2
 * @Date: 2020/12/21 10:47
 * @Operation:
 * @Description:
 *
 * 1470. 重新排列数组
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 *
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,5,1,3,4,7], n = 3
 * 输出：[2,3,5,4,1,7]
 * 解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
 *
 *
 * 输入：nums = [1,2,3,4,4,3,2,1], n = 4
 * 输出：[1,4,2,3,3,2,4,1]
 *
 * https://leetcode-cn.com/problems/shuffle-the-array/
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] a = new int[]{5,6,1,7};
        int[] nums = solution.shuffle(a,2);
        for (int i : nums){
            System.out.println(i);
        }
    }

    /**
     *
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
        if(n < 2){
            return nums;
        }
        int[] result = new int[nums.length];
        for (int i = 0,j = 0;i < nums.length - 1;i+=2,j++){
            result[i] = nums[j];
            result[i+1] = nums[n+j];
        }
        return result;
    }
}
