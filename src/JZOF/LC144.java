package JZOF;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC144 {
    /*给你二叉树的根节点 root ，返回它节点值的 前序 遍历。*/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stk = new Stack<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                res.add(root.val);
                root = root.left;
            }
            root=stk.pop();
            root=root.right;

        }
        return res;
    }
}
