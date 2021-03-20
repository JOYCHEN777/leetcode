package JZOF;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素
 * ，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class LC59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int num = 1;
        while (num < n * n) {

            for (int i = left; i <= right; i++) {
                res[top][i] = num;
                num++;
            }
            for (int i = top + 1; i <= bottom; i++) {
                res[i][right] = num;
                num++;
            }
            for (int i = right - 1; i >= left + 1; i--) {
                res[bottom][i] = num;
                num++;
            }
            for (int i = bottom; i >= top + 1; i--) {
                res[i][left] = num;
                num++;
            }
                    top++;
            bottom--;
            left++;
            right--;
        }
        return res;
    }

}
