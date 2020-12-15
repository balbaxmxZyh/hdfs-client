package leetcode.day08;

/**
 * @Author: zhangyh
 * @ClassName: Solution4
 * @Date: 2020/12/3 16:21
 * @Operation:
 * @Description:
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *  
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution5 {

    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(10);
//        ListNode node5 = new ListNode(11);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;
        ListNode node = solution.reverseKGroup(node1,2);
//        ListNode node = solution.rever(node1);
        while (node != null){

            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * 快慢指针
     * 快指针到k，2k，nk，不走，慢指针开始走k个节点
     * left：记录每次反转第一个节点的pre，0（pre）、k、2k
     * right：记录每次反转最后一个节点的next，k+1、2k+1
     * 慢指针逻辑(从a开始)：
     * left -> a -> b -> c -> right
     * right <- a <- b <- c <- left
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode quick = head;
        ListNode slow = head;
        int a = 0;

        ListNode left = pre;

        ListNode right = null;
        ListNode c = slow;
        ListNode n = null;
        while (quick != null || a == k){
            if(a != k){
                a++;
                quick = quick.next;
                right = quick;
                continue;
            }

            if(a == k) {
                while (a > 0) {
                    a--;
                    n = c.next;
                    c.next = right;
                    right = c;
                    c = n;
                }
                ListNode next =  left.next;
                left.next = right;
                left = next;
            }

        }

        return pre.next;
    }

    public ListNode rever(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null){
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }
}
