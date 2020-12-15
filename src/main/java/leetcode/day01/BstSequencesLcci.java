package leetcode.day01;

import sun.awt.SunHints;

import java.util.*;

/**
 * @Author: zhangyh
 * @ClassName: BstSequencesLcci
 * @Date: 2020/10/15 8:34
 * @Operation:
 * @Description: https://leetcode-cn.com/problems/bst-sequences-lcci/
 */
public class BstSequencesLcci {

    /**分为两步骤进行
     * 1、分层次节点集合   list<>
     * 2、从上到下把每个层次从左输出/从有输出
    **/
    public static void main(String[] args) {
        List<String> lits = Arrays.asList("1","2");
        lits.subList(0,lits.size());
        BstSequencesLcci bstSequencesLcci = new BstSequencesLcci();
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(6);
//        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;
        List<List<Integer>> list = bstSequencesLcci.BSTSequences(node1);


    }

    private List<String> result = new ArrayList<>();

    public List<List<Integer>> BSTSequences(TreeNode root) {
        if(root == null){
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<Integer>());
            return list;
        }
        List<List<Integer>> list = new ArrayList<>();
        List<String> strings = Arrays.asList(String.valueOf(root.val));
        rePath(root,strings);
        return list;
    }

    public void rePath(TreeNode root,List<String> list) {
        if(root.left != null && root.right != null){

            for (String s : list){
                String temp1 = s+","+root.left.val+","+root.right.val;
                String temp2 = s+","+root.right.val+","+root.left.val;
                result.add(temp1);
                result.add(temp2);
            }
            rePath(root.left,result);
            rePath(root.right,result);

        }else if(root.left != null && root.right == null){
            for (String s : list){
                String temp1 = s+","+root.left.val;
                result.add(temp1);
            }
        }else if(root.left == null && root.right != null){
            for (String s : list){
                String temp1 = s+","+root.right.val;
                result.add(temp1);
            }
        }
    }

    public void re(TreeNode root, Map<Integer ,List<TreeNode>> result, int num) {
        List<TreeNode> list = result.get(num);
        if(list == null){
            list = new ArrayList<>();
        }
        if(root.left != null){
            list.add(root.left);
            int n = num+1;
            re(root.left,result,n);
        }
        if(root.right != null){
            list.add(root.right);
            int n = num+1;
            re(root.right,result,n);
        }
        if(list.size() > 0){
        result.put(num,list);
        }
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
}
