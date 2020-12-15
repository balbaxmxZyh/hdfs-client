package leetcode.day09;

/**
 * @Author: zhangyh
 * @ClassName: Solution3
 * @Date: 2020/12/4 15:00
 * @Operation:
 * @Description:
 *
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution = new Solution3();

        System.out.println(solution.strStr2("heejkjllo","llo"));
    }

    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()){
            return 0;
        }
        if(haystack.isEmpty()){
            return -1;
        }
        int p = 0;
        int c = 0;
        while (p < haystack.length()){
            if(haystack.charAt(p) == needle.charAt(c)){
                if(++c >= needle.length()){
                    break;
                }
            }else {
                p = p - c;
                c = 0;
            }
            p++;
        }
        if(c == needle.length()){
            return p - c + 1;
        }
        return -1;
    }


    /**
     * 偏移表
     *
     * haystack[start+c] == needle ,返回start
     * haystack[start+c] ！= needle，start++
     *
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle) {
        if(needle.isEmpty()){
            return 0;
        }
        if(haystack.isEmpty()){
            return -1;
        }
        for (int i = 0 ;i <= haystack.length() - needle.length() ;i++){
            if(needle.equals(haystack.substring(i,i+needle.length()))){
                return i;
            }
        }

        return -1;

    }
}
