package JZOF;

import java.util.Scanner;

/**
 * 她发现了一个n×m的迷宫里面充满了宝藏，不幸的是，因为她的贸然踏入，迷宫将在K秒后坍塌。
 * 在此之前，她想拿到尽可能多的宝物，请帮她规划一下路线。
 * 给出n×m的迷宫内各个位置的描述，可能是不可经过的障碍物，可能是有价值的宝物。
 * 小A默认在洞穴的入口，她能且仅能向紧邻的上下左右迷宫房间移动或者站在原地不动，均耗时1s，
 * 当经过宝物时，宝物会自动拾取，不会消耗小A的时间，
 * 但经过相同格子多次，宝物仅在第一次拾取（拾取后就进小A钱包啦，不能重复拾取），
 * 请帮她规划好路线，能获得最大价值并且在K秒之内返回洞口。
 * 假如她在i行j列，向上移动指移动到(i-1,j)
 * 向下移动指移动到(i+1,j)
 * 向右移动指移动到(i,j+1)
 * 向左移动指移动到(i,j-1)
 * 她在任何时候不能移动到迷宫边界之外。迷宫左上角为(1,1)，右下角为(n,m)
 */
public class WZ2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int K = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
            }
        }
        if(K==1){
            System.out.println(map[x-1][y-1]);
        }else if(K==2||f_max(map,x-1,y-1)==-1){
            System.out.println(map[x-1][y-1]+Math.max(f_max(map,x-1,y-1),0));
        }
    }

    public static int move(int[][] map, int i, int j) {
        if(i>=map.length||i<0){
            return -1;
        }else if(j>map[0].length-1||j<0){
            return -1;
        }else{
            return map[i][j];
        }
    }
    public static int f_max(int[][] map, int i, int j){
        int max=move(map,i,j-1);
        max=Math.max(max,move(map,i,j+1));
        max=Math.max(max,move(map,i+1,j));
        max=Math.max(max,move(map,i-1,j));
        return max;
    }

    public static void dfs(int[][] map, int i, int j,int res){
        if(f_max(map,i,j)==-1){
            return;
        }

    }
}
