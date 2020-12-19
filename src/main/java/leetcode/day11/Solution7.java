package leetcode.day11;

/**
 * @Author: zhangyh
 * @ClassName: Solution7
 * @Date: 2020/12/18 23:00
 * @Operation:
 * @Description:
 *
 *
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
 *
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：command = "G()(al)"
 * 输出："Goal"
 * 解释：Goal 解析器解释命令的步骤如下所示：
 * G -> G
 * () -> o
 * (al) -> al
 * 最后连接得到的结果是 "Goal"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/goal-parser-interpretation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution7 {

    public static void main(String[] args) {
        Solution7 solution = new Solution7();

        System.out.println(solution.interpret("G()(al)"));

    }


    public String interpret(String command) {
        if(command == null|| command.length() == 0){
            return command;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0;i < command.length();i++){
            if(command.charAt(i) == 'G'){
                builder.append('G');
            }else if(command.charAt(i) == '(' && command.charAt(i+1) == ')'){
                i++;
                builder.append('o');
            }else {
                i+=3;
                builder.append("al");
            }
        }
        return builder.toString();
    }
}
