package leetcode.day03;

/**
 * @Author: zhangyh
 * @ClassName: Solution2
 * @Date: 2020/11/18 11:12
 * @Operation:
 * @Description: https://leetcode-cn.com/problems/palindrome-number/
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 */
public class Solution4 {
    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        System.out.println(solution.isPalindrome2(11011));
    }

    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        if(x >= 0 && x <= 9){
            return true;
        }
        int[] ints = new int[10];
        int i = -1;
        int pop;
        while (x != 0){
            i++;
            pop = x % 10;
            x = x/10;
            ints[i] = pop;
        }
        for (int j = 0;j < i;j++,i--){
            if(ints[i] != ints[j]){
                return false;
            }
        }
        return true;
    }


    public boolean isPalindrome2(int x) {
        if(x < 0){
            return false;
        }
        if(x >= 0 && x <= 9){
            return true;
        }
        int pop;
        int sum = 0;
        int temp = x;
        while (x != 0){
            pop = x % 10;
            x = x/10;
            sum=sum*10 + pop;
        }

        return temp == sum;
    }
}
