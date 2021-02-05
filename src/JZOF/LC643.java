package JZOF;

public class LC643 {
    /*给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。*/
    public static double findMaxAverage(int[] nums,int k){
        int sum=0;
        double res;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        res=((double)sum)/k;
        for(int i=0;i<nums.length-k;i++){
            int out=nums[i];
            int in=nums[i+k];
            sum=sum-out+in;
            res=Math.max(res,((double)sum)/k);
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums={1,12,-5,-6};
        int k=2;
        System.out.println(findMaxAverage(nums,k));
    }
}
