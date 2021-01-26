package JZOF;

import java.lang.reflect.Array;
import java.util.Arrays;

/*输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

 */
public class JZ4 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        if (pre.length == 1) {
            return new TreeNode(pre[0]);
        }
        int rootVal = pre[0];
        TreeNode res = new TreeNode(rootVal);
        int loc = 0;
        for (int i = 0; i < pre.length; i++) {
            if (in[i] == rootVal) {
                loc = i;
                break;
            }
        }
        res.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, loc+1), Arrays.copyOfRange(in, 0, loc ));
        res.right = reConstructBinaryTree(Arrays.copyOfRange(pre, loc + 1, pre.length ), Arrays.copyOfRange(in, loc + 1, in.length ));

        return res;


    }

    public static void main(String[] args) {
        JZ4 jz4 = new JZ4();
        TreeNode treeNode = jz4.reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
        TreeNode.mid(treeNode);
    }
}
