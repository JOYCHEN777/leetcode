package JZOF;

public class LC1004 {
    /*
    给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。

返回仅包含 1 的最长（连续）子数组的长度。*/
    public int longestOnes(int[] A, int K) {
        //此题可理解为求包含K个0的最大窗口
        int res = 0;
        /**左右指针，（l,r] 左开右闭，count用来计数，size是当前窗口大小
         *
         */
        int l = -1;
        int r = 0;
        int countZero = 0;
        int size = 0;
        while (r < A.length) {
            //每次移动右指针，遇到0时候count+1
            if (A[r] == 0) {
                countZero++;
            }
            //当窗口内刚好有K+1个0时，(l,r-1]窗口内则刚好为K个0，求出窗口大小
            if (countZero > K) {
                size = r - l - 1;
                res = Math.max(res, size);
                //计算完大小后移动左指针到下个0的位置，循环内判断的是指针的下一位，所以循环外要再加一，
                while (l < r && A[l + 1] != 0) {
                    l++;
                }
                l++;
                countZero--;
            }
            r++;
        }
        //此时可能窗口中0的数量还小于K，不满足计算窗口大小的条件，要再计算一次
        size = r - l-1;
        res = Math.max(res, size);
        return res;
    }

}
