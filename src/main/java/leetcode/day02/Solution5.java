package leetcode.day02;

/**
 * @Author: zhangyh
 * @ClassName: Solution3
 * @Date: 2020/11/16 16:08
 * @Operation:
 * @Description: https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 *
 *
给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。


 */
public class Solution5 {

    public static void main(String[] args) {
        Solution5 solution = new Solution5();


        //123345569 10
        System.out.println(solution.longestPalindromeSubseq("bbbab"));

    }

    public int longestPalindromeSubseq(String s) {
        if(s.isEmpty()){
            return 0;
        }
        int n = s.length();
        int[][] a = new int[n][n];
        for (int i = 0;i < n ;i++){
            a[i][i] = 1;
        }
        for (int i = n-1 ;i >= 0;i--){
            for (int j = i+1 ;j < n;j++){
                if(s.charAt(i) == s.charAt(j)){
                    a[i][j] = a[i+1][j-1] +2;
                }else {
                    a[i][j] = Math.max(a[i+1][j],a[i][j-1]);
                }
            }
        }
        return a[0][n-1];
    }




}
