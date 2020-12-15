package leetcode.day01;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangyh
 * @ClassName: EvaluateOnlyChar
 * @Date: 2020/10/14 16:01
 * @Operation:
 * @Description:
 */
public class EvaluateOnlyChar {

    public static void main(String[] args) {
        EvaluateOnlyChar aChar= new EvaluateOnlyChar();
        System.out.println(aChar.isUnique("abcdefg"));
    }


    public boolean isUnique(String astr) {
        if(astr.length() == 0){
            return true;
        }

        int[] a = new int[128];
        char[] bytes = astr.toCharArray();
        for (char c : bytes){
            if(a[c] == 0){
                a[c]++;
            }else {
                return false;
            }
        }
        return true;
    }


}
