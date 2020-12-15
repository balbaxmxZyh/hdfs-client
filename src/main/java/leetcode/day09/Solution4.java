package leetcode.day09;

import javax.xml.crypto.Data;

/**
 * @Author: zhangyh
 * @ClassName: Solution4
 * @Date: 2020/12/4 15:47
 * @Operation:
 * @Description: \
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 *  
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution4 {
    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        long l = System.currentTimeMillis();
        System.out.println(solution.divide(-1,-2));
        System.out.println(System.currentTimeMillis() - l);
    }


    public int divide(int dividend, int divisor) {
        if(dividend == 0 || divisor == 0){
            return 0;
        }

        if(dividend < dividend){
            return 0;
        }

        int sum = 0;
        //异或 （同为0，异为1）
        // ^
        int negative = dividend ^ divisor;

        if(dividend > 0){
            dividend = -dividend;
        }
        if(divisor > 0){
            divisor = -divisor;
        }
        int d = divisor;
        int a = 1;
        while (d+d > Integer.MIN_VALUE &&  dividend <= d+d){
            a = a + a;
            d = d + d;
        }
        dividend -= d;
        sum+=a;

        while (dividend <= divisor){
            if(negative < 0 && -sum > Integer.MIN_VALUE -1){
                return Integer.MAX_VALUE;
            }
            if(negative >= 0 && sum > Integer.MAX_VALUE -1){
                return Integer.MAX_VALUE;
            }
            sum++;
            dividend -= divisor;
        }

        if(negative < 0){
            return -sum;
        }
        return sum;
    }


    public int doubleDivi(int dividend, int divisor,int num){
        if(dividend > divisor){
            doubleDivi(dividend,divisor+dividend,num+num);
        }
        return num;
    }
}
