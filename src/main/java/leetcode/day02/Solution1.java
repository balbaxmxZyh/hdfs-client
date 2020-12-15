package leetcode.day02;

import java.util.ArrayDeque;
import java.util.Calendar;
import java.util.Queue;

/**
 * @Author: zhangyh
 * @ClassName: Solution1
 * @Date: 2020/11/16 14:08
 * @Operation:
 * @Description: https://leetcode-cn.com/problems/valid-parentheses/
 *
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        boolean s = solution.isValid2("(()())");
        System.out.println(s);
    }


    public boolean isValid(String s) {
        ArrayDeque<Character> queue = new ArrayDeque<>();
        char[] chars =  s.toCharArray();
        for (Character character : chars){
            if(character.equals('(')
                    || character.equals('{')
                    || character.equals('[')){
                queue.add(character);
            }else if(character.equals(')')){
                Character c = queue.pollLast();
                if(c != null && c.equals('(')){
                    continue;
                }else {
                    return false;
                }
            }else if(character.equals('}')){
                Character c = queue.pollLast();
                if(c != null && c.equals('{')){
                    continue;
                }else {
                    return false;
                }
            }else if(character.equals(']')){
                Character c = queue.pollLast();
                if(c != null && c.equals('[')){
                    continue;
                }else {
                    return false;
                }
            }
        }
        if(queue.size() > 0){
            return false;
        }
        return true;
    }


    public boolean isValid2(String s) {
        if(s.isEmpty()){
            return false;
        }
        if(s.length() % 2 != 0){
            return false;
        }
        char[] chars = s.toCharArray();
        char[] lefts = new char[s.length() / 2];
        int index = 0;
        for (char c : chars){
            if(c == '('
                    ||c == '{'
                    ||c == '['){
                if(index >= s.length() / 2){
                    return false;
                }
                lefts[index] = c;
                index++;
            }else {
                if(c == ')' && index > 0 && '(' == lefts[index-1]){
                    index--;
                    continue;
                }
                if(c == '}' && index > 0 && '{' == lefts[index-1]){
                    index--;
                    continue;
                }
                if(c == ']' && index > 0 && '[' == lefts[index-1]){
                    index--;
                    continue;
                }
                return false;
            }
        }
        if(index != 0){
            return false;
        }
        return true;
    }
}
