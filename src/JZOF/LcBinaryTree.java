package JZOF;

import java.util.*;

public class LcBinaryTree {
    /*给你一个二叉树的根节点 root ，返回其最大路径和。

    本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径 至少包含一个 节点，且不一定经过根节点。*/
    public static int maxPathSum(TreeNode root) {
        int res = -1001;
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> list=new ArrayList<>();
        while (root!=null||!stack.isEmpty()){

            while (root!=null){
                stack.push(root);
                int temp=root.val+Math.max(maxGain(root.left),0)+Math.max(maxGain(root.right),0);
                list.add(maxGain(root));
                root=root.left;
            }
                root=stack.pop();
                root=root.right;

        }
        res= Collections.max(list);

        return res;
    }

    public static int maxGain(TreeNode root) {
        int res = -1001;
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res = root.val;
            return res;
        }
        int left=Math.max(maxGain(root.left),0);
        int right=Math.max(maxGain(root.right),0);
        res=Math.max(root.val+left,root.val+right);

        return res;
    }

    public static void main(String[] args) {
        JZ4 jz4 = new JZ4();
        TreeNode treeNode = jz4.reConstructBinaryTree(new int[]{1, 2}, new int[]{1, 2});
        System.out.println(maxPathSum(treeNode));
    }

}