package JZOF;

public class LC5657 {
    /*
    * 给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
    请你返回 nums 中唯一元素的 和 。*/
    public int sumOfUnique(int[] nums) {
        int res=0;
        int[] mark=new int[101];
        for(int i=0;i<nums.length;i++){
            mark[nums[i]]++;
        }
        for(int i=0;i<=100;i++){
            if(mark[i]==1){
                res+=i;
            }
        }
        return res;
    }

}
