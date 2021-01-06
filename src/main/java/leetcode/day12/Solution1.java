package leetcode.day12;

import sun.tools.attach.HotSpotVirtualMachine;

/**
 * @Author: zhangyh
 * @ClassName: Solution1
 * @Date: 2020/12/21 10:23
 * @Operation:
 * @Description:
 *
 * 面试题 02.03. 删除中间节点
 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 *
 *
 *
 * 示例：
 *
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 *
 *
 * https://leetcode-cn.com/problems/delete-middle-node-lcci/
 * ''
 *
 * 输入某个节点（不是头结点也不是尾结点，删除这个节点）
 */
public class Solution1 {

    public static void main(String[] args) {

        ListNode root11 = new ListNode(2);
        ListNode root12 = new ListNode(4);
        ListNode root13 = new ListNode(9);
        root11.next=root12;
        root12.next=root13;
        Solution1 solution = new Solution1();
        solution.deleteNode(root12);

        while (root11 != null){
            System.out.println(root11.val);
            root11 = root11.next;
        }
    }


    /**
     * 删除自己
     * 把next的值复制给自己，让next.next复制给自己的next
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    static public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
