package JZOF;

public class LC104 {
    public int maxDepth(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }else{
            res=1+Math.max(maxDepth(root.right),maxDepth(root.left));
        }

        return res;
    }
}
