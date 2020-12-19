package study.priority;

import java.util.Stack;

/**
 * @Author: zhangyh
 * @ClassName: StackTest
 * @Date: 2020/12/17 8:56
 * @Operation:
 * @Description: ${description}
 */
public class StackTest {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }
}
