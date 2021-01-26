package JZOF;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC236 {
    /*给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
    最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res=root;
        List<TreeNode> l1=storeRoot(root,p);
        List<TreeNode> l2=storeRoot(root,q);
        for(int i=0;i<=l1.size()-1;i++){
            TreeNode temp1=l1.get(i);
            for(int j =0;j<=l2.size()-1;j++){
                TreeNode temp2=l2.get(j);
                if(temp1==temp2){
                    return temp1;
                }
            }
        }
        return res;
    }
    public static List<TreeNode> storeRoot(TreeNode root, TreeNode p){
        TreeNode last=null;
        List<TreeNode> res=new ArrayList<>();
        Stack<TreeNode> stk=new Stack<>();
        while(root!=null||!stk.isEmpty()){
            while (root!=null){
                stk.push(root);
                root=root.left;
            }
            root=stk.peek();
            if(root==p){
                while (!stk.isEmpty()){
                    res.add(stk.pop());
                }
                return res;
            }
            else if(root.right==null||root.right==last){
                stk.pop();
                last=root;
                root=null;
            }else {
                root = root.right;
            }

        }
        return res;
    }
    public static TreeNode lowestCommonAncestor2(TreeNode root,TreeNode p,TreeNode q){
        if(root==null||root==p||root==q){
            return root;
        }
        TreeNode rLeft=lowestCommonAncestor(root.left,p,q);
        TreeNode rRight=lowestCommonAncestor(root.left,p,q);
        if(rLeft!=null&&rRight!=null){
            return root;
        }
        else if(rRight==null){
            return rLeft;
        }
        else{
            return rRight;
        }



    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(5);
        root.right=new TreeNode(1);
        root.left.left=new TreeNode(6);
        root.left.right=new TreeNode(2);
        root.right.left=new TreeNode(0);
        root.right.right=new TreeNode(8);

        System.out.println((lowestCommonAncestor(root,root.left,root.right)).val);

        
    }
}
