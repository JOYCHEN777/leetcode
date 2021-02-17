package JZOF;

public class LC665 {
    /*
    * 给你一个长度为n的整数数组，请你判断在 最多 改变1 个元素的情况下，该数组能否变成一个非递减数列。
我们是这样定义一个非递减数列的：对于数组中所有的i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
*/
    public static boolean checkPossibility(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > nums[i]) {
                if (k < 1) {
                    return false;
                } else {
                    if (i >= 2 && nums[i] < nums[i - 2]) {
                        nums[i] = nums[i - 1];
                    }
                    k--;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] n = new int[]{3, 5, 100, 4,200,200};
        System.out.println(checkPossibility(n));

    }
}
