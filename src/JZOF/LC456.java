package JZOF;

public class LC456 {
    public static boolean find132pattern(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return false;
        }
        int len = nums.length;
        //int[] r=new int[len];
        int[] l = new int[len];
        l[0]=nums[0];
        for (int i = 1; i < len; i++) {
            l[i] = Math.min(l[i - 1], nums[i - 1]);
            System.out.println(l[i]);
            System.out.println(nums[i]);
            if (nums[i] > l[i] + 1) {
                for (int j = i + 1; j < len; j++) {
                    if (nums[j] > l[i] && nums[j] < nums[i]) {
                        return true;
                    }

                }
            }
        }

        return false;
    }
    public static void main(String[] args){
        int[] a=new int[]{3,2,1,4};
        System.out.println(find132pattern(a));
    }
}
