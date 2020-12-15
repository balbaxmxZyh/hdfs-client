package leetcode.day07;

/**
 * @Author: zhangyh
 * @ClassName: Solution1
 * @Date: 2020/11/23 9:57
 * @Operation:
 * @Description:
 *
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = solution.removeNthFromEnd2(node1,1);

        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n < 1){
            return head;
        }
        ListNode node = reverserLink(head);
        ListNode current = node;
        ListNode pre = null;
        int i = 1;
        while (current != null){
            if(i == n){
                if(pre!= null) {
                    pre.next = current.next;
                }else {
                    node = current.next;
                }
                break;
            }
            pre = current;
            current = current.next;
            i++;
        }

        node = reverserLink(node);
        return node;
    }


    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverserLink(ListNode head) {

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


    static public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 快慢指针
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(n < 1){
            return head;
        }
        ListNode dumyNode = new ListNode(-1);
        dumyNode.next = head;
        ListNode fast = dumyNode;
        ListNode slow = dumyNode;

        while (fast != null && n + 1 > 0 ){
            fast = fast.next;
            n--;
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dumyNode.next;
    }
}
