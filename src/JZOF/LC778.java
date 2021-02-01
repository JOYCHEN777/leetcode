package JZOF;

import java.util.List;

public class LC778 {
    /*在一个 N x N 的坐标方格grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。
现在开始下雨了。当时间为t时，此时雨水导致水池中任意位置的水位为t。
你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。
假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台(N-1, N-1)？
*/
    public static int swimInWater(int[][] grid) {
        int n = grid.length;
        int target=grid[n - 1][n - 1];
        int res = Math.max(grid[0][0],target)-1;
        boolean dfs = false;

        while (!dfs) {
            res++;
            int[][] temp=new int[n][n];
            for(int a=0;a<n;a++){
                System.arraycopy(grid[a], 0, temp[a], 0, n);
            }
            dfs = swimDfs(temp, 0, 0, res, n, target);
        }
        return res;
    }

    public static boolean swimDfs(int[][] grid, int i, int j, int t, int n, int target) {
        if (i < 0 || i > n - 1 || j < 0 || j > n - 1 || grid[i][j] > t) {
            return false;
        }
        if (grid[i][j] == target) {
            return true;
        }

        grid[i][j] = n * n;
        return swimDfs(grid, i - 1, j, t, n, target) ||
                swimDfs(grid, i + 1, j, t, n, target) ||
                swimDfs(grid, i, j - 1, t, n, target) ||
                swimDfs(grid, i, j + 1, t, n, target);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 2}, {1, 3}};
        System.out.println(swimInWater(grid));
    }
}

