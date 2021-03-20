package JZOF;

public class LC5669 {
    /**
     * 给你一个长度为 n 的二维整数数组 groups ，同时给你一个整数数组 nums 。
     * 你是否可以从 nums 中选出 n 个 不相交 的子数组，
     * 使得第 i 个子数组与 groups[i] （下标从 0 开始）完全相同，
     * 且如果 i > 0 ，那么第 (i-1) 个子数组在 nums 中出现的位置在第 i 个子数组前面。
     * （也就是说，这些子数组在 nums 中出现的顺序需要与 groups 顺序相同）
     * 如果你可以找出这样的 n 个子数组，请你返回 true ，否则返回 false 。
     * 如果不存在下标为 k 的元素 nums[k] 属于不止一个子数组，就称这些子数组是 不相交 的。
     * 子数组指的是原数组中连续元素组成的一个序列。
     */
    public static boolean canChoose(int[][] groups, int[] nums) {
        int r = 0;
        for (int i = 0; i < groups.length; i++) {
            int len = groups[i].length;
            int count = 0;
            if (r >= nums.length) {
                return false;
            } else {
                while (count < len) {
                    if (r >= nums.length) {
                        return false;
                    }
                    if (nums[r] == groups[i][count]) {
                        r++;
                        count++;
                        if (r >= nums.length) {
                            break;
                        }
                    } else {

                        r = r + 1 - count;
                        count = 0;
                    }
                }
            }
            if(count<len){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] groups = new int[][]{{1}, {3, 4}, {6, 7, 8}};

        int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        //
        // System.out.println(canChoose(groups, nums));
        int a=150;
        char b=(char)a;
        System.out.println();
    }
}
/*

[[6551094,9427527,2052462,3481286,-7620442],[8495362,-1820796],[-1005271,-6911519],[-9667242,9997184,-9316362],[-9278108,-7479063,-7573091,-1775876,-2612810,-241649]]
[6551094,6551094,9427527,2052462,3481286,-7620442,-7620442,8495362,-1820796,-1005271,-6911519,-9667242,9997184,-9316362,9997184,-9278108,-7479063,-7573091,-1775876,-2612810,-241649] */