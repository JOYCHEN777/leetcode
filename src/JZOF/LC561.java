package JZOF;

import java.util.Arrays;

public class LC561 {
    /*给定长度为2n的整数数组 nums ，
    你的任务是将这些数分成n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
    使得从 1 到n 的 min(ai, bi) 总和最大。
返回该 最大总和 。
*/
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res=0;
        for(int i=0;i<nums.length/2;i++){
            res+=nums[2*i];
        }
        return res;
    }
}
