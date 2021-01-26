package JZOF;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC145 {
    //二叉树后续遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stk = new Stack<>();
        TreeNode last = null;
        while (root != null||!stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.peek();
            if (root.right == null || root.right == last) {
                res.add(root.val);
                stk.pop();
                last = root;
                root = null;
            } else {
                root = root.right;
            }
        }
        return res;
    }
}
