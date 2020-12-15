package leetcode.day02;

/**
 * @Author: zhangyh
 * @ClassName: Solution3
 * @Date: 2020/11/16 16:08
 * @Operation:
 * @Description: https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 *
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。


 */
public class Solution6 {

    public static void main(String[] args) {
        Solution6 solution = new Solution6();


        //123345569 10
        System.out.println(solution.longestPalindrome("aba"));

    }

    public String longestPalindrome(String s) {
        if(s.isEmpty()){
            return "";
        }
        int n = s.length();
        Boolean[][] strings = new Boolean[n][n];
        for (int i = 0 ;i < n ;i++){
            strings[i][i] = true;
        }
        int begin = 0;
        int max = 1;
        for (int i = n-1 ;i >= 0;i--){
            for (int j = i+1 ;j < n;j++){
                if(s.charAt(i) != s.charAt(j)){
                    strings[i][j] = false;
                }else {
                    if(j - i < 3){
                        strings[i][j] = true;
                    }else {
                        strings[i][j] = strings[i+1][j-1];

                    }
                }
                if(strings[i][j]){
                    int temp = j-i+1;
                    if(temp > max){
                        begin = i;
                        max = temp;
                    }
                }
            }
        }
        return s.substring(begin,begin+max);
    }

 /*   public String longestPalindrome(String s) {
        if(s.isEmpty()){
            return "";
        }
        int n = s.length();
        int max = 0;
        String index = s.charAt(0)+"";
        for (int i = 0 ;i < n;i++){
            for (int j = i+1 ;j < n;j++){
                String s1 = s.substring(i,j+1);
                if(isSubseq(s1)){
                    if((j+1-i) > max) {
                        max = Math.max((j + 1 - i), max);
                        index = s1;
                    }
                }
            }
        }
        return index;
    }


    public boolean isSubseq(String s) {
        int n = s.length();
        for (int i = 0,j = n-1 ;i < j;i++,j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }*/

}
