package study.priority;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @Author: zhangyh
 * @ClassName: PriorityQueueTest
 * @Date: 2020/12/16 17:12
 * @Operation:
 * @Description: ${description}
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(3);
        queue.offer(2);
        queue.remove(1);
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
