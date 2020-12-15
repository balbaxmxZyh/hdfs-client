package leetcode.day02;

import java.util.HashMap;

/**
 * @Author: zhangyh
 * @ClassName: Solution3
 * @Date: 2020/11/16 16:08
 * @Operation:
 * @Description: https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 * 优化:
 * 单循环
 * map记录出现的位置
 */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution = new Solution3();

        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));

    }

    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }
        int[] a = new int[127];
        int max = 0;
        int index = 0;
        char[] chars = s.toCharArray();
        for (int i = 0;i < chars.length;i++){
            for (int j = i;j < chars.length;j++) {
                char c = chars[j];
                if (a[c] == 0) {
                    a[c] = 1;
                    index++;
                }else {
                    break;
                }
            }
            if (index > max) {
                max = index;
            }
            a = new int[127];
            index = 0;
        }

        return max;
    }



}
