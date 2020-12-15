package leetcode.day07;

/**
 * @Author: zhangyh
 * @ClassName: Solution2
 * @Date: 2020/11/23 14:03
 * @Operation:
 * @Description: https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Solution2 {

    public static void main(String[] args) {

        Solution2 solution = new Solution2();
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(20);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(10);
        ListNode n5 = new ListNode(12);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode node = solution.mergeTwoLists(l1,n1);

        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode pre = new ListNode(-1);
        ListNode head = pre;
        pre.next = l1;
        while (l1 != null){
            if(l2 != null && l1.val > l2.val){
                ListNode next = l2.next;
                pre.next = l2;
                pre.next.next = l1;
                pre = l2;
                l2 = next;
            }else{
                pre = l1;
                l1 = l1.next;
            }

        }
        if(l2 != null){
            pre.next = l2;
        }
        return head.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
