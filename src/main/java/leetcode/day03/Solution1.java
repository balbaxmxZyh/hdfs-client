package leetcode.day03;

/**
 * @Author: zhangyh
 * @ClassName: Solution3
 * @Date: 2020/11/16 16:08
 * @Operation:
 * @Description: https://leetcode-cn.com/problems/zigzag-conversion/
 *
 *
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：


 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();


        //123345569 10
        System.out.println(solution.convert2("AB",2));

    }

    public String convert(String s, int numRows) {
        if(s.isEmpty() || s.length() <= numRows || numRows < 2){
            return s;
        }

        int n = (numRows-1)*(s.length() / (2*numRows-2));
        int mod = s.length() % (2*numRows-2);
        if(mod != 0){
            if(mod > numRows){
                n= n + 1 + mod - numRows;
            }else {
                n++;
            }
        }

        char[][] a = new char[n][numRows];
        int index = 0;
        int remainder;
        for (int i = 0;i < n;i++ ){
            if(index >= s.length()){
                break;
            }
            remainder = i % (numRows-1);
            if(remainder == 0) {
                for (int j = 0; j < numRows; j++) {
                    if(index >= s.length()){
                        break;
                    }
                    a[i][j] = s.charAt(index);
                    index++;
                }
            }else {
                a[i][numRows-1-remainder] = s.charAt(index);
                index++;
            }
        }
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i< numRows;i++){
            for(int j = 0; j< n;j++){
                if(a[j][i] != '\u0000'){
                    builder.append(a[j][i]);
                }
            }
        }
        return builder.toString();
    }


    /**
     * 当0 ~ n-1 的时候指针是正向走
     * 当n ~ 2n-2（不包括）的时候指针是方向
     * @param s
     * @param numRows
     * @return
     */
    public String convert2(String s, int numRows) {
        if(s.isEmpty() || s.length() <= numRows || numRows < 2){
            return s;
        }
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cyble = 2*numRows -2 ;
        for( int i=0;i<numRows;i++){
            for(int j =0;j+i <n;j+=cyble){
                ret.append(s.charAt(i+j));
                if( i !=0 && i != numRows-1 && j+cyble-i <n ){
                    ret.append(s.charAt(j+cyble-i));
                }
            }
        }
        return ret.toString();

    }


}
