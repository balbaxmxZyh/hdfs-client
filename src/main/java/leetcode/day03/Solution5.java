package leetcode.day03;

/**
 * @Author: zhangyh
 * @ClassName: Solution2
 * @Date: 2020/11/18 11:12
 * @Operation:
 * @Description: https://leetcode-cn.com/problems/palindrome-number/
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution5 {
    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        System.out.println(solution.isMatch("",""));
    }

    public boolean isMatch(String s, String p) {
        if(s.isEmpty()){
            if(!p.isEmpty()){
                if(p.length() == 1 && p.charAt(0) == '.'){
                    return true;
                }else if(p.length() == 2 && p.charAt(0) == '.' && p.charAt(1) == '*'){
                    return true;
                }else {
                    return false;
                }
            }
            return true;
        }



        return true;
    }
}
