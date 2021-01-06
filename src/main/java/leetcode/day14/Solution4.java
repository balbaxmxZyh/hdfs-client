package leetcode.day14;

import org.apache.hadoop.hdfs.server.datanode.fsdataset.LengthInputStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: zhangyh
 * @ClassName: Solution4
 * @Date: 2021/1/5 13:46
 * @Operation:
 *
 *
 * 二叉树广度
 */
public class Solution4 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);

        node1.right = node2;
        node2.left = node3;
        node2.right = node4;
        node3.right = node5;
        node5.right = node6;
        Solution4 solution = new Solution4();
        System.out.println(solution.distanceKFind(node1,node2,0));
    }




    public List<Integer> distanceKFind(TreeNode root, TreeNode target, int K) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,List<TreeNode>> hashMap = new HashMap<>();
        List<TreeNode> l = new ArrayList<>();
        l.add(root);
        hashMap.put(0,l);
        chooseNode(root,root.left,1,hashMap);
        chooseNode(root,root.right,-1,hashMap);

        return list;
    }

    /**
     *
     * @param root 节点
     * @param num 当前节点距离根节点路径 有正负
     * @param hashMap 集合
     */
    public void chooseNode(TreeNode parent,TreeNode root,int num,HashMap<Integer,List<TreeNode>> hashMap) {
            if(root != null){
                if(hashMap.get(num) == null){
                    List<TreeNode> l = new ArrayList<>();
                    l.add(root);
                    hashMap.put(num,l);
                }else {
                    hashMap.get(num).add(root);
                }
                if(num < 0) {
                    num = num-1;
                }else {
                    num = num+1;
                }
                chooseNode(root,root.left,num,hashMap);
                chooseNode(root,root.right,num,hashMap);
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
