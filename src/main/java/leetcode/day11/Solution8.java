package leetcode.day11;

/**
 * @Author: zhangyh
 * @ClassName: Solution8
 * @Date: 2020/12/18 23:18
 * @Operation:
 * @Description:
 *
 * 1684. 统计一致字符串的数目
 * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
 *
 * 请你返回 words 数组中 一致字符串 的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出：2
 * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 * 示例 2：
 *
 * https://leetcode-cn.com/problems/count-the-number-of-consistent-strings/
 */
public class Solution8 {

    public static void main(String[] args) {
        Solution8 solution = new Solution8();
        String[] strings = new String[]{"ab","abcde","abdec","hucodjfab","bjijcjka"};
        System.out.println(solution.countConsistentStrings("abc",strings));
    }

    /**
     * 把allowed放在一个26数组dp中，对于a-z出现的次数
     * 遍历words每个字符串，
     * 再遍历字符串的字符，假设该字符dp[c] != 0,则退出
     * @param allowed
     * @param words
     * @return
     */
    public int countConsistentStrings(String allowed, String[] words) {
        if(allowed == null || allowed.length() == 0){
            return words == null ? 0 : words.length;
        }
        if(words == null || words.length == 0){
            return 0;
        }
        int[] dp  = new int[26];
        for (char c : allowed.toCharArray()){
            dp[c - 'a'] = 1;
        }

        int account = 0;
        for (String s : words){
            boolean flag = true;
            for (char c : s.toCharArray()){
                if(dp[c - 'a'] != 1){
                    flag = false;
                    break;
                }
            }
            if(flag){
                account++;
            }
        }

        return account;

    }
}
