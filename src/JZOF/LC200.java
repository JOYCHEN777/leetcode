package JZOF;
/*给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。
*/
public class LC200 {
    public int island(char[][] grid){
        int res=0;
        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){

                    dfs(grid,i,j);
                    res=res+1;
                }
            }
        }
        return res;
    }
    private void dfs(char[][] grid,int i, int j){
        if(i<0||j<0||i> grid.length-1||j>grid[i].length-1){
            return;
        }
        if(grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }

}
