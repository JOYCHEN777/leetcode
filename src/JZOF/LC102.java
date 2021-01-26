package JZOF;

import java.util.*;

public class LC102 {
    /*给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。*/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        else{
            Queue<TreeNode> queue=new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                List<Integer> level=new ArrayList<>();
                int len=queue.size();
                for(int i=0;i<len;i++){
                    TreeNode node=queue.poll();
                    level.add(node.val);
                    if(node.left!=null){
                        queue.offer(node.left);
                    }
                    if(node.right!=null){
                        queue.offer(node.right);
                    }
                }
                res.add(level);
            }

        }
        return res;
    }
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
    public static void main(String[] args){
        List<List<Integer>> list=new ArrayList<>();

        System.out.println(list);
    }
}
