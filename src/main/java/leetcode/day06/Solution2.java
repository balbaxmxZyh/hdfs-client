package leetcode.day06;


/**
 * @Author: zhangyh
 * @ClassName: Solution2
 * @Date: 2020/11/22 18:29
 * @Operation:
 * @Description:
 *
 * 单链表返向
 */
public class Solution2 {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Solution2 solution = new Solution2();
        Node root = solution.linkRevert(node1);
        while (root != null){
            System.out.println(root.val);
            root = root.next;
        }
    }

    public Node linkRevert(Node root){

        Node pre = null;
        Node current = root;
        Node next = null;
        while (current != null){
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        return pre;
    }


    static class Node {
        int val;
        Node next;
        Node(int x) { val = x; }
    }
}
