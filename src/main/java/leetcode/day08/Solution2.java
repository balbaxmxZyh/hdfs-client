package leetcode.day08;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangyh
 * @ClassName: Solution2
 * @Date: 2020/12/3 10:33
 * @Operation:
 * @Description: ${description}
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        List<String> list = solution.generateParenthesis(3);
        System.out.println(list);
    }


    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n < 1){
            list.add("");
            return list;
        }

        createStr(list,n,n,"",0);
        return list;
    }


    public void createStr(List<String> list ,int left,int right,String str,int remain){

        if(left > 0 && right > 0){
            createStr(list,left-1,right,str+"(",remain+1);
        }
        if(right > 0){
            if(str != "" && remain > 0){
                createStr(list,left,right-1,str+")",remain-1);
            }
        }
        if(left == 0 && right==0){
            list.add(str);
        }
    }

}
