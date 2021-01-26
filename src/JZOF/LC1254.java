package JZOF;

public class LC1254 {
    public int closedIsland(int[][] grid) {

        int res = 0;
        int val = 1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    val=0;
                    dfs(grid,i,j);
                    res=res+val;
                }
            }
        }
        return res;


    }

    public void dfs(int[][] grid, int i, int j) {
        if(i<=0||j<=0||i>= grid.length||j>= grid[i].length){
            return;
        }
        if(grid[i][j]==1){
            return;
        }
        grid[i][j]=1;
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);


    }
}
