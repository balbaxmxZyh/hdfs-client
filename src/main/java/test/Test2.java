package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangyh
 * @ClassName: Test2
 * @Date: 2020/12/11 14:43
 * @Operation:
 * @Description: ${description}
 */
public class Test2 {

    public static void main(String[] args) {
        int[] a = new int[]
                {1,0,1,1,1,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,1,0,0,0,1,0,0,1,1,1,1,1,1,0,1,1,0,1,0,0,0,0,0,0,1,0,1,1,1,0,0,1,0};
        List<Boolean> b = prefixesDivBy5(a);
        System.out.println(b.toString());
       /* Test2 test2 = new Test2();
        System.out.println(test2.convertToTitle(1000000001));*/

    }


    public static List<Boolean> prefixesDivBy5(int[] A) {
        if (A == null || A.length < 1) {
            return null;
        }
        List<Boolean> result = new ArrayList<>();
        int sum = 0;

        for (int j = 0; j < A.length; j++) {
            sum = (sum + A[j]) % 10;
            if (sum % 5 == 0) {
                result.add(true);
            }else {
                result.add(false);
            }
            sum = sum*2;
        }
        return result;
    }

    char[] num = new char[]{
            'A', 'B', 'C', 'D', 'E', 'E', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    public String convertToTitle(int n) {
        if(n < 1){
            return "";
        }
        char[] num = new char[]{
                'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O',
                'P','Q','R','S','T','U','V','W','X','Y','Z'
        };
        StringBuilder builder = new StringBuilder();
        while (n > 26){
            int yushu = n % 26;
            n = n / 26;
            if(yushu == 0){
                n = n -1;
                builder.append('Z');
            }else {
                builder.append(num[yushu - 1]);

            }
        }
        builder.append(num[n-1]);
        StringBuilder builder2 = new StringBuilder();
        for (int i = builder.length() - 1;i >= 0;i--){
            builder2.append(builder.charAt(i));
        }
        return builder2.toString();

    }



}