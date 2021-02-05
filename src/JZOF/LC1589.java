package JZOF;

import java.util.Arrays;

public class LC1589 {
    /*有一个整数数组nums，和一个查询数组requests，其中requests[i] = [starti, endi]。
    第i个查询求nums[starti] + nums[starti + 1] + ... + nums[endi - 1] + nums[endi]的结果，
    starti 和endi数组索引都是 从 0 开始 的。
你可以任意排列 nums中的数字，请你返回所有查询结果之和的最大值。
由于答案可能会很大，请你将它对10^9 + 7取余后返回。*/
    public static int maxSumRangeQuery(int[] nums, int[][] requests) {
        long s = 0;
        int res;
        int[] sum = new int[nums.length];
        for (int[] request : requests) {
            sum[request[0]]++;
            if (request[1] + 1 < nums.length) {
                sum[request[1] + 1]--;
            }
        }
        for(int i=1;i<sum.length;i++){
            sum[i]=sum[i]+sum[i-1];
        }
        Arrays.sort(sum);
        Arrays.sort(nums);
        int i = nums.length - 1;
        while (i >= 0 && sum[i] > 0) {
            s += (long)sum[i] * nums[i];
            i--;
        }
        res = (int) (s % (1000000007));
        return res;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 1};
        int[][] request = new int[][]{{0, 1}, {0, 2}, {1, 2}};
        System.out.println(maxSumRangeQuery(nums, request));
    }

}
