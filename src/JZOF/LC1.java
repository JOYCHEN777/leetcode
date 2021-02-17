package JZOF;

import java.util.Arrays;
import java.util.HashMap;

public class LC1 {
    /*
    给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 的那两个整数，并返回它们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
    你可以按任意顺序返回答案。
 */
    public int[] twoSum(int[] nums, int target) {
        int[] res=new int[]{0,1};
        if(nums.length==2){
            return res;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])&&map.get(target-nums[i])!=i){
                res[0]=i;
                res[1]=map.get(target-nums[i]);
                break;
            }
        }
        return res;

}}
/*时间29%
public int[] twoSum(int[] nums, int target) {
        int[] res=new int[]{0,1};
        if(nums.length==2){
            return res;
        }
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    res[0]=i;
                    res[1]=j;
                }
            }
        }
        return res;
    }
}
 */
