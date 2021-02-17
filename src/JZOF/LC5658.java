package JZOF;

import java.util.Arrays;

public class LC5658 {
    /*
    * 给你一个整数数组 nums 。
    * 一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的
    *  和的绝对值 为 abs(numsl + numsl+1 + ... + numsr-1 + numsr) 。
    请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。
    abs(x) 定义如下：
    如果 x 是负整数，那么 abs(x) = -x 。
    如果 x 是非负整数，那么 abs(x) = x 。*/
    public static int maxAbsoluteSum(int[] nums) {
        int res;
        int[] sum=new int[nums.length];
        sum[0] =nums[0];
        for(int i=1;i<nums.length;i++){
            int temp=i-1;
            sum[i]=sum[temp]+nums[i];
        }
        Arrays.sort(sum);
        if(sum[0]>=0){
            res=sum[sum.length-1];
        }else if(sum[sum.length-1]<0){
            res=-sum[0];
        }else{
            res=sum[sum.length-1]-sum[0];
        }
        return res;
    }
    public  static  void main(String[] args){
        int[] nums=new int[]{1,-3,2,3,-4,-5};
        System.out.println(maxAbsoluteSum(nums));

    }
}
