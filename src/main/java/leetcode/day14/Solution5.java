package leetcode.day14;

import com.sun.javadoc.SeeTag;

import java.util.*;

/**
 * @Author: zhangyh
 * @ClassName: Solution4
 * @Date: 2021/1/5 13:46
 * @Operation:
 * @Description: https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/
 *
 *
 * 863. 二叉树中所有距离为 K 的结点
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 *
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 *
 *
 * 改造一下可以进行深度搜索
 */
public class Solution5 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.right = node5;
        node4.left = node6;
        Solution5 solution = new Solution5();
        System.out.println(solution.distanceK(node1,node2,2));
    }
    //节点的父子关系
    private HashMap<TreeNode,TreeNode> paren = new HashMap<>();
    //结果
    private Set<Integer> set = new HashSet<>();
    //找过的节点
    private Set<TreeNode> find = new HashSet<>();


    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();
        findParent(root,root.left);
        findParent(root,root.right);
        //给每个节点添加一个父节点
        findDistance(target,K);
        result.addAll(set);
        return result;
    }


    public void findDistance(TreeNode target, int K) {
        if(target != null && !find.contains(target)) {
            find.add(target);
            if(K == 0){
                set.add(target.val);
                return;
            }
            findDistance(target.left,K-1);
            findDistance(target.right,K-1);
            if(paren.get(target)!= null){
                findDistance(paren.get(target),K-1);
            }
        }

    }


    public void findParent(TreeNode parent, TreeNode target) {
        if(target != null){
            this.paren.put(target,parent);
            findParent(target,target.left);
            findParent(target,target.right);
        }
    }



    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
