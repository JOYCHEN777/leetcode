package JZOF;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*给定一个二叉树，返回其节点值的锯齿形层次遍历。
（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。*/
public class LC103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int order=1;
        while (!queue.isEmpty()) {
            List<Integer> sub = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                root = queue.poll();
                if(order%2==1){
                sub.add(root.val);}
                else{
                    sub.add(0,root.val);
                }
                if (root.left != null) {
                    queue.offer((root.left));
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            order++;
            res.add(sub);

        }
        return res;
    }

    private void addToList(List<TreeNode> nodes, List<Integer> list, TreeNode node) {
        if (node != null && list != null && nodes != null) {
            list.add(node.val);
            nodes.add(node);
        }
    }

}
