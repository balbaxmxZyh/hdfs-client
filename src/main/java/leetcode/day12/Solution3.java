package leetcode.day12;

/**
 * @Author: zhangyh
 * @ClassName: Solution3
 * @Date: 2020/12/21 11:10
 * @Operation:
 * @Description:
 *
 * 剑指 Offer 58 - II. 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 *
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *
 *
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution = new Solution3();

        System.out.println(solution.reverseLeftWords("abcdefg",3));
    }

    /**
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        if(n == 0 || n >= s.length()){
            return s;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(s, n, s.length());
        builder.append(s, 0, n);
        return builder.toString();
    }


    public String reverseLeftWords2(String s, int n) {
        if(n == 0 || n >= s.length()){
            return s;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = n;i < s.length();i++){
            builder.append(s.charAt(i));
        }
        for (int i = 0;i < n;i++){
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}
