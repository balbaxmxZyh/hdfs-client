package leetcode.day03;

/**
 * @Author: zhangyh
 * @ClassName: Solution2
 * @Date: 2020/11/18 11:12
 * @Operation:
 * @Description: https://leetcode-cn.com/problems/reverse-integer/
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        System.out.println(solution.reverse(-2147483640));
    }

    public int reverse(int x) {
        if(x <= Integer.MIN_VALUE || x >= Integer.MAX_VALUE) {
            return 0;
        }

        String s = String.valueOf(x);
        if(s.length() == 1){
            return x;
        }
        StringBuilder builder = new StringBuilder();
        boolean isFshu = false;
        for (int i = s.length()-1 ; i >= 0;i--){
            char c = s.charAt(i);
            if(c != '-') {
                builder.append(c);
            }else {
                isFshu = true;
            }
        }

        Long l = Long.valueOf(builder.toString());
        if(isFshu){
            l = l*-1;
        }
        if(l <= Integer.MIN_VALUE || l>= Integer.MAX_VALUE) {
            return 0;
        }
        return l.intValue();
    }

    public int reverse2(int x) {
        int sum = 0;
        while (x != 0){
            int o = x % 10;
            x = x / 10;
            //判定当前位数+一个，大于最大值
            //或者当前位数+一位，等于且最后一位大于7
            if(sum > Integer.MAX_VALUE/10
                    ||(sum == Integer.MAX_VALUE/10 && o > 7)){
                return 0;
            }
            //判定当前位数+一个，小于最小值
            //或者当前位数+一位，等于且最后一位小于8
            if(sum < Integer.MIN_VALUE/10
                    ||(sum == Integer.MIN_VALUE/10 && o < -8)){
                return 0;
            }
            sum = sum*10 + o;
        }
        return sum;
    }
}
