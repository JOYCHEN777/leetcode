package JZOF;

import java.util.HashMap;

/**
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，
 * 使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC220 {
    public static void main(String[] args) {
        int[] nums=new int[]{2147483647,-2147483647};
        int k=1;
        int t=2147483647;
        System.out.println(containsNearbyAlmostDuplicate(nums,k,t));
        int a=2147483647;
        int b=-a;
        long dif=a-(long)b;
        System.out.println(dif);

        System.out.println(2&4);
    }
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        HashMap<Integer,Integer> b=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int id=getBucketId(nums[i],t);
            if(b.containsKey(id)){
                return true;
            }else if(b.containsKey(id+1)){
                long dif=(long)nums[i]-(long)b.get(id+1);
                if(Math.abs(dif)<=t){
                    return true;
                }
            }else if(b.containsKey(id-1)){
                long dif=(long)nums[i]-(long)b.get(id-1);
                if(Math.abs(dif)<=t){
                    return true;
                }
            }
            b.put(id,nums[i]);
            if(i-k>=0){
                b.remove(getBucketId(nums[i-k],t));
            }
        }

        return false;
    }
    public static int getBucketId(int i,int t){
        if(i>=0){
            return i/(t+1);
        }else{
            return -((-i-1)/(t+1)+1);
        }
    }
}
