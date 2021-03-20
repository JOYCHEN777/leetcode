package JZOF;

import java.util.ArrayList;
import java.util.List;

public class LC697 {
    /**
     * 给定一个非空且只包含非负数的整数数组nums，数组的度的定义是指数组里任一元素出现频数的最大值。
     * 你的任务是在 nums 中找到与nums拥有相同大小的度的最短连续子数组，返回其长度。
     */
    public static int findShortestSubArray(int[] nums) {
        /**
         * count数组用来统计每个数出现的次数
         */
        int[] count = new int[50000];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        /**
         * 找出数组的度：count[index]
         */
        int index = 0;
        for (int i = 0; i < 50000; i++) {
            if (count[i] > count[index]) {
                index = i;
            }
        }
        /**
         * 找出数量和度相同的所有元素
         */
        List<Integer> store = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            if (count[i] == count[index]) {
                store.add(i);
            }
        }
        int ret=50000;
        /**
         * 遍历符合要求的元素求长度
         */
        for (int n : store) {
            int l = 0;
            int r = nums.length - 1;
            while (nums[l] != n) {
                l++;
            }
            while (nums[r] != n) {
                r--;
            }
            ret=Math.min(ret,r-l+1);
        }
        return ret;
    }
    public static void main(String[] args){
        int[] nums=new int[]{1,2,2,3,1};
        System.out.println(findShortestSubArray(nums));
    }
}
