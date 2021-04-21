package JZOF;

import java.sql.SQLOutput;
import java.util.*;

public class EasyTest {
    public static void main(String[] args) {
        String s = "123";
        int[] nums=new int[]{1,2,3,2,2,2,5,4,2};
        System.out.println(majorityElement(nums));

    }
    public static int majorityElement(int[] nums) {
        if(nums.length<=2){
            return nums[0];
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(map.get(nums[i])>=nums.length/2){
                    return nums[i];
                }
                int v = map.get(nums[i]);
                map.put(nums[i], v+1);
            }
            else{
                map.put(nums[i],1);
            }
        }

        return 1;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> que=new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            int l=que.size();
            for(int i=0;i<l;i++){
                TreeNode node=que.poll();
                temp.add(node.val);
                if(node.left!=null){
                    que.offer(node.left);
                }
                if(node.right!=null){
                    que.offer((node.right));
                }
            }
            res.add(temp);
        }

        return res;
    }
}