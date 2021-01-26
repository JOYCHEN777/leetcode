package JZOF;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC94 {
    /*给定一个二叉树的根节点 root ，返回它的 中序 遍历。*/
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null||!stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;

            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public static void main(String[] args){

        JZ4 jz4 = new JZ4();
        TreeNode treeNode = jz4.reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
        System.out.println(inorderTraversal(treeNode));

    }
}
