package test;

import java.math.BigDecimal;

/**
 * @Author: zhangyh
 * @ClassName: CharToBit
 * @Date: 2020/12/19 11:12
 * @Operation:
 * @Description: ${description}
 */
public class CharToBit {
    public static void main(String[] args) {
        BigDecimal decimal1 = new BigDecimal(1);
        System.out.println(decimal1.equals(new BigDecimal(1)));
        String ip = "255.255.255.255";
        System.out.println(ip.getBytes().length);
    }
}
