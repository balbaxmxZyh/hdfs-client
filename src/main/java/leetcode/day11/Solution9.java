package leetcode.day11;

/**
 * @Author: zhangyh
 * @ClassName: Solution9
 * @Date: 2020/12/18 23:50
 * @Operation:
 * @Description:
 * 1672. 最富有客户的资产总量
 * 给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i​​​​​​​​​​​​ 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
 *
 * 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
 *
 *
 *
 * 示例 1：
 *
 * 输入：accounts = [[1,2,3],[3,2,1]]
 * 输出：6
 * 解释：
 * 第 1 位客户的资产总量 = 1 + 2 + 3 = 6
 * 第 2 位客户的资产总量 = 3 + 2 + 1 = 6
 * 两位客户都是最富有的，资产总量都是 6 ，所以返回 6 。
 *
 *
 * https://leetcode-cn.com/problems/richest-customer-wealth/
 */
public class Solution9 {

    public static void main(String[] args) {
        Solution9 solution = new Solution9();
        int[][] a = new int[][]{
                {2,8,9},
                {7,1,3},
                {1,9,5}
        };
        System.out.println(solution.maximumWealth(a));
    }

    /**
     * 两个指针左右同时遍历客户
     * 遍历客户是有账号，选出最大值
     * @param accounts
     * @return
     */
    public int maximumWealth(int[][] accounts) {
        if(accounts.length == 0){
            return 0;
        }
        int max = -1;
        for (int left = 0,right = accounts.length -1;left <= right;left++,right--){
            int sum = 0;
            for (int i : accounts[left]){
                sum+=i;
            }
            max = Math.max(max,sum);
            sum = 0;
            for (int i : accounts[right]){
                sum+=i;
            }
            max = Math.max(max,sum);
        }
        return max;
    }
}
