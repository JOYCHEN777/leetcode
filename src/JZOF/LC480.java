package JZOF;

import java.util.Arrays;

public class LC480 {
    /*中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
例如：
[2,3,4]，中位数是3
[2,3]，中位数是 (2 + 3) / 2 = 2.5
给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。
窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
     */
    public static double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length - k + 1;
        double[] res = new double[len];
        for(int i=0;i<len;i++){
            int[] temp=new int[k];
            for(int j=0;j<k;j++){
                temp[j]=nums[i+j];
            }
            Arrays.sort(temp);
            int sum=temp[k/2]+temp[(k-1)/2];
            res[i]=sum/2.0;
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums=new int[]{2147483647,2147483647};
        int k=2;
        double[] res=medianSlidingWindow(nums,k);
        for(double r:res){
            System.out.println(r);
        }
/* public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int cnt = n - k + 1;
        double[] ans = new double[cnt];
        int[] t = new int[k];
        for (int l = 0, r = l + k - 1; r < n; l++, r++) {
            for (int i = l; i <= r; i++) t[i - l] = nums[i];
            Arrays.sort(t);
            ans[l] = (t[k / 2] / 2.0) + (t[(k - 1) / 2] / 2.0);
        }
        return ans;
    }
* */
    }
}
