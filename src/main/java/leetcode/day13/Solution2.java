package leetcode.day13;

/**
 * @Author: zhangyh
 * @ClassName: Solution2
 * @Date: 2020/12/28 21:49
 * @Operation:
 * @Description:
 *
 * 1108. IP 地址无效化
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 *
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 *
 *
 *
 * 示例 1：
 *
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 * 示例 2：
 *
 * 输入：address = "255.100.50.0"
 * 输出："255[.]100[.]50[.]0"
 *
 * https://leetcode-cn.com/problems/defanging-an-ip-address/
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.defangIPaddr("1.1.1.1"));
    }


    public String defangIPaddr(String address) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0 ;i < address.length();i++){
            if(address.charAt(i) == '.'){
                builder.append("[.]");
            }else {
                builder.append(address.charAt(i));
            }
        }
        return builder.toString();
    }
}
