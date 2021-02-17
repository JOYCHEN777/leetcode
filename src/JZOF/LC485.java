package JZOF;

public class LC485 {
    /*给定一个二进制数组， 计算其中最大连续 1 的个数。
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0){
                res = Math.max(temp, res);
                temp = 0;
            }else{
                temp++;
                if (i == nums.length - 1) {
                    res = Math.max(temp, res);
                }
            }
            if(nums.length-1-i<=res){
                return res;
            }

        }
        return res;
    }
}
