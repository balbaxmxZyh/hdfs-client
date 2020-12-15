package leetcode.day04;

/**
 * @Author: zhangyh
 * @ClassName: Solution2
 * @Date: 2020/11/20 10:41
 * @Operation:
 * @Description: ${description}
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String[] strings = new String[]{"flower"};
        System.out.println(solution.longestCommonPrefix(strings));
    }



    public String longestCommonPrefix(String[] strs) {
        if(strs.length < 1){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        StringBuilder builder = new StringBuilder();
        int min = Integer.MAX_VALUE;
        for (String s : strs){
            min = Math.min(s.length(),min);
        }
        for (int i = 0 ;i < min;i++){
            char c = strs[0].charAt(i);
            for (int j = 1 ;j < strs.length;j++){
                if(c != strs[j].charAt(i)){
                    return builder.toString();
                }
            }
            builder.append(c);
        }
        return builder.toString();

    }
}
