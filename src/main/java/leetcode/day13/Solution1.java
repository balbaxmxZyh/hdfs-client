package leetcode.day13;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangyh
 * @ClassName: Solution1
 * @Date: 2020/12/22 9:38
 * @Operation:
 * @Description:
 *
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class Solution1 {


    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3= new TreeNode(20);
        TreeNode node4= new TreeNode(15);
        TreeNode node5= new TreeNode(7);
        TreeNode node6= new TreeNode(2);
        TreeNode node7= new TreeNode(3);


        node1.left =  node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        node2.left = node6;
        node2.right = node7;
        List<List<Integer>> list = solution.zigzagLevelOrder(node1);

        list.forEach(System.out::println);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> start = new ArrayList<>();
        addList(root,list,start,true);

        return list;

    }

    public void  addList(TreeNode root, List<List<Integer>> list,List<Integer> node,boolean isAdd) {
        if(root != null){
            node.add(root.val);
            if(isAdd) {
                list.add(node);
            }
            List<Integer> next = new ArrayList<>();
            addList(root.left,list,next,true);
            addList(root.right,list,next,false);
        }
    }



    static public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
