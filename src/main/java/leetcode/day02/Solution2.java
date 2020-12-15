package leetcode.day02;

/**
 * @Author: zhangyh
 * @ClassName: Solution2
 * @Date: 2020/11/16 15:16
 * @Operation:
 * @Description: ${description}
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        ListNode root11 = new ListNode(2);
        ListNode root12 = new ListNode(4);
        ListNode root13 = new ListNode(9);
        root11.next=root12;
        root12.next=root13;

        ListNode root21 = new ListNode(5);
        ListNode root22 = new ListNode(6);
        ListNode root23 = new ListNode(2);
        ListNode root24 = new ListNode(1);
        ListNode root25 = new ListNode(1);


        root21.next = root22;
        root22.next = root23;
        root23.next = root24;
        root24.next = root25;


        ListNode n = solution.addTwoNumbers(root13,root25);

        while (n != null){
            System.out.println(n.val);
            n = n.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        boolean flag = true;
        ListNode result  = null;
        ListNode next = null;
        int account1 = 0;
        while (flag){
            if(l1 == null && l2 == null && account1 == 0){
                break;
            }
            int a = 0;
            int b = 0;
            if(l1 != null){
                a = l1.val;
            }
            if(l2 != null){
                b = l2.val;
            }
            int account = account1 + a + b;
            //十位
            account1 = account / 10;
            //个位
            int account2 = account % 10;
            ListNode node  = new ListNode(account2);
            if(result == null){
                result = node;
                next = node;
            }else {
                next.next = node;
                next = node;
            }

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
       return result;
    }


    static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
