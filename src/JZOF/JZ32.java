package JZOF;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印
 * ，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 */
public class JZ32 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        int level = 0;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (list.size() > 0) {
            int size = list.size();
            List<Integer> ans = new ArrayList<>();
            if (level % 2 == 0) {
                for (int i = 0; i < size; i++) {
                    TreeNode node=list.poll();
                    ans.add(node.val);
                    if(node.left!=null) list.add(node.left);
                    if(node.right!=null) list.add(node.right);
                }
            }else{
                for (int i = 0; i < size; i++) {
                    TreeNode node=list.poll();
                    ans.add(0,list.poll().val);
                    if(node.left!=null) list.add(node.left);
                    if(node.right!=null) list.add(node.right);

                }
            }
            level++;
            res.add(ans);
        }
        return res;
    }
}
