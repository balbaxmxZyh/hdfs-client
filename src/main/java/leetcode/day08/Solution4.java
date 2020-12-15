package leetcode.day08;

/**
 * @Author: zhangyh
 * @ClassName: Solution4
 * @Date: 2020/12/3 16:21
 * @Operation:
 * @Description: https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 */
public class Solution4 {

    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(10);
        ListNode node5 = new ListNode(11);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = solution.swapPairs(node1);
//        ListNode node = solution.merge(node1,nodex1);
        while (node != null){

            System.out.println(node.val);
            node = node.next;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;
        while (head != null){
            if(head.next != null){
                ListNode next = head.next;
                ListNode nextNext = next.next;
                pre.next = next;
                next.next = head;
                head.next = nextNext;
                pre = head;
                head = head.next;
                continue;
            }
            break;
        }
        return node.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }
}
