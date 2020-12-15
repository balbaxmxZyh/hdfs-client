package leetcode.day08;

import leetcode.day07.Solution1;

/**
 * @Author: zhangyh
 * @ClassName: Solution3
 * @Date: 2020/12/3 14:11
 * @Operation:
 * @Description:
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(10);
        ListNode node5 = new ListNode(11);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        ListNode nodex1 = new ListNode(1);
        ListNode nodex2 = new ListNode(3);
        ListNode nodex3 = new ListNode(4);
        nodex1.next = nodex2;
        nodex2.next = nodex3;

        ListNode nodey1 = new ListNode(2);
        ListNode nodey2 = new ListNode(6);
        ListNode nodey3 = new ListNode(9);
        nodey1.next = nodey2;
//        nodey2.next = nodey3;

        ListNode[] listNode = new ListNode[]{node1,nodex1,nodey1};

        ListNode node = solution.mergeKLists(listNode);
//        ListNode node = solution.merge(node1,nodex1);
        while (node != null){

            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length < 1){
            return null;
        }
        if(lists.length == 1 ){
            return lists[0];
        }

        ListNode node = fenLists(0,lists.length-1,lists);
        return node;
    }


    /**
     * 类似归并算法
     * @param start
     * @param end
     * @param lists
     * @return
     */
    public ListNode fenLists(int start ,int end,ListNode[] lists) {

        if(start<end){
            int mid = (start+end) / 2;
            fenLists(start, mid, lists);
            fenLists(mid + 1, end, lists);
            ListNode node = merge(lists[start],lists[mid+1]);
            lists[start] = node;
        }

        return lists[0];
    }



    public ListNode merge(ListNode root1,ListNode root2) {
        if(root1 == null){
            return root2;
        }

        if(root2 == null){
            return root1;
        }
        ListNode head = new ListNode(-1);
        head.next = root1;

        ListNode pre = head;
        while (root1 != null && root2 != null){
            if(root1.val > root2.val){
                pre.next = root2;
                ListNode next = root2.next;
                root2.next = root1;
                pre = root2;
                root2 = next;
            }else {
                pre = root1;
                root1 = root1.next;
            }
        }

        if(root2 != null){
            pre.next = root2;
        }
        return head.next;
    }


     public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

}
