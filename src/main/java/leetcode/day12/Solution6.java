package leetcode.day12;

/**
 * @Author: zhangyh
 * @ClassName: Solution6
 * @Date: 2020/12/21 14:13
 * @Operation:
 * @Description:
 *
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jewels-and-stones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution6 {

    public static void main(String[] args) {
        Solution6 solution = new Solution6();
        System.out.println(solution.numJewelsInStones("ABCabc","abchjhkjdnwABIUYHWNC"));
    }

    /**
     * aABC 映射为int[],dp[a]==1 表示 a为宝石
     * dp[a]==0 表示a不是宝石
     * 一次遍历
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {

        if(J==null || J.length() == 0 || S == null || S.length()==0){
            return 0;
        }

        int[] dp = new int[58];
        for (char c : J.toCharArray()){
            dp[c - 'A'] = 1;
        }
        int total = 0;
        for (char c : S.toCharArray()){
            if(dp[c - 'A'] == 1){
                total++;
            }
        }
        return total;
    }
}
