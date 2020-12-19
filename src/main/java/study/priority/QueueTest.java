package study.priority;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zhangyh
 * @ClassName: QueueTest
 * @Date: 2020/12/17 8:52
 * @Operation:
 * @Description: ${description}
 */
public class QueueTest {

    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<Integer>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
