package leetcode.day11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: zhangyh
 * @ClassName: Solution3
 * @Date: 2020/12/16 21:54
 * @Operation:
 * @Description:
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        System.out.println(solution.longestValidParentheses("()((()()))"));
    }


    /**
     * 堆里面最后一个代表的是匹配不到‘(’的下标（刚开始是-1）
     * 当是'('下标放入stack
     * 当是')'的时候pop，如果stack变null，则说明
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        int max = 0 ;
        stack.push(-1);
        for (int i = 0 ;i < s.length();i++){
            if('(' == s.charAt(i)){
                stack.push(i);
            }else if(')' == s.charAt(i)){
                stack.pop();
                if(stack.isEmpty()){
                    //匹配不到
                    stack.push(i);
                }else {
                    //能匹配到
                    max = Math.max(max,i-stack.peek());
                }
            }

        }
        return max;
    }
}
