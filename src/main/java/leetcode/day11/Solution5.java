package leetcode.day11;

import org.apache.xerces.dom.RangeImpl;

/**
 * @Author: zhangyh
 * @ClassName: Solution5
 * @Date: 2020/12/18 16:32
 * @Operation:
 * @Description:
 *
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *
 * https://leetcode-cn.com/problems/find-the-difference/
 */
public class Solution5 {

    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        System.out.println(Integer.valueOf('a'));
        System.out.println(solution.findTheDifference("aabcd","acdaba"));
    }

    /**
     * 创建int[] dp ,dp[i]=j表示 s在i字符出现j次
     *
     * 遍历t，k表示字符，当dp[k]=0，则表示k没出现
     *
     * 遍历可以双指针
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        if(s.length() == 0){
            return t.charAt(0);
        }
        int[] dp = new int[26];
        for (int left = 0,right = s.length()-1;left <= right;left++,right--){
            dp[s.charAt(left) % 26] = dp[s.charAt(left) % 26]+1;
            if(left != right) {
                dp[s.charAt(right) % 26] = dp[s.charAt(right) % 26] + 1;
            }

        }

        for (int left = 0,right = t.length()-1;left <= right;left++,right--){
            if(dp[t.charAt(left) % 26] < 1 ){
                return t.charAt(left);
            }else {
                dp[t.charAt(left) % 26]--;
            }
            if(left != right) {
                if(dp[t.charAt(right) % 26] < 1 ){
                    return t.charAt(right);
                }else {
                    dp[t.charAt(right) % 26]--;
                }
            }

        }
        return t.charAt(0);
    }



    public char findTheDifference2(String s, String t) {
        if(s.length() == 0){
            return t.charAt(0);
        }
        int[] dp = new int[26];
        for (int left = 0;left < s.length();left++){
            dp[s.charAt(left) % 26] = dp[s.charAt(left) % 26]+1;
        }

        for (int left = 0;left < t.length();left++){
            if(dp[t.charAt(left) % 26] < 1 ){
                return t.charAt(left);
            }else {
                dp[t.charAt(left) % 26]--;
            }

        }
        return t.charAt(0);
    }
}
