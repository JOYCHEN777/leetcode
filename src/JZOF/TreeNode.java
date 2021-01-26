package JZOF;

public class TreeNode {
    TreeNode right;
    TreeNode left;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }

    public static void pre(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.val + ",");
        pre(treeNode.left);
        pre(treeNode.right);
    }

    public static void mid(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        mid(treeNode.left);
        System.out.print(treeNode.val + " ");
        mid(treeNode.right);
    }

    public static void aft(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        aft(treeNode.left);
        aft(treeNode.right);
        System.out.print(treeNode.val + " ");
    }
}
