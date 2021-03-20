package JZOF;

import java.util.ArrayList;
import java.util.List;

public class LC54 {
    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0;
        int bottom = m - 1;
        int l = 0;
        int r = n - 1;
        int mr=0;
        while (top <= bottom &&l <= r) {
            if (top <= bottom&l<=r) {
                for (int i = l; i <= r; i++) {
                    res.add(matrix[top][i]);
                    mr=r;

                }
                top++;
            }
            if (l <= r&&top!=bottom) {
                for (int i = top; i < bottom; i++) {
                    res.add(matrix[i][r]);

                }
                r--;
            }
            if (top <= bottom&&l<=mr) {
                for (int i = mr; i >= l; i--) {
                    res.add(matrix[bottom][i]);

                }
                bottom--;
            }
            if (l <= r&&top!=bottom) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][l]);

                }
                l++;
            }
        }

        return res;
    }
    public static void main(String[] args){
        int[][] matrix=new int[][]{{1,2,3,4},{4,5,6,7},{7,8,9,10},{1,2,3,4}};
        spiralOrder(matrix);
    }
}
