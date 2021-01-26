package JZOF;

public class LC672 {
    /*给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
    连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，
    如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，
    那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
*/
    public int findLengthOfLCIS(int[] nums) {
        int res = 0;
        if (nums == null || nums.length < 1) {
            return res;
        }
        if (nums.length == 1) {
            res = 1;
            return res;
        }
        int i = 0;
        int j = 1;
        //int temp = 0;
        while (j <= nums.length - 1) {
            while (j <= nums.length - 1 && nums[j] > nums[j - 1]) {
                j++;
            }
            res = Math.max(res, j - i);
            //temp = j - i;不需要这个变量了
            i = j;
            j = i + 1;
        }
        return res;
    }
}
