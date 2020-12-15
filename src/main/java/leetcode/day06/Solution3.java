package leetcode.day06;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangyh
 * @ClassName: Solution2
 * @Date: 2020/11/22 18:29
 * @Operation:
 * @Description: https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class Solution3 {

    public static void main(String[] args) {
        String a = "22";
        Solution3 solution = new Solution3();
        List<String> list = solution.letterCombinations(a);
        System.out.println(list);
    }


    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<Character,String> map = new HashMap(){
            {
                put('2',"abc");
                put('3',"def");
                put('4',"ghi");
                put('5',"jkl");
                put('6',"mno");
                put('7',"pqrs");
                put('8',"tuv");
                put('9',"wxyz");
            }
        };

        for (char c :digits.toCharArray()){
            if(map.get(c) != null) {
                result = let(result, map.get(c));
            }else {
                return new ArrayList<>();
            }
        }
        return result;
    }


    public List<String> let(List<String> list,String a) {
        List<String> result = new ArrayList<>();
        if(list.isEmpty()){
            for (char c : a.toCharArray()){
                result.add(c+"");
            }
            return result;
        }
        for (String s :list){
            for (char c : a.toCharArray()){
                result.add(s+c);
            }
        }
        return result;
    }
}
