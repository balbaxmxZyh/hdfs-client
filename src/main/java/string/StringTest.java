package string;

/**
 * @Author: zhangyh
 * @ClassName: StringTest
 * @Date: 2020/12/27 20:33
 * @Operation:
 * @Description: ${description}
 */
public class StringTest {

    public static void main(String[] args) {
        String str2 = new String("str")+new String("01");
        String str1 = "str01";
        String str3 = str2.intern();
        System.out.println(str2==str1); //true

    }
}
