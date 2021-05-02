package BS;

import java.util.Arrays;
import java.util.Scanner;

public class AL1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(func(arr,x1-1,y1-1,x2-1,y2-1));
    }
    public static int func(int[][] arr,int x1,int y1,int x2,int y2){
        if(arr[x1][y1]>arr[x2][y2]){
            return -1;
        }
        int res=-1;
        int min=Integer.MAX_VALUE;
        dfs(arr,x1,y1,x2,y2,res,min);
        return min;

    }
    public static int dfs(int[][] arr,int x1,int y1,int x2,int y2,int res,int min){
        if(arr[x1][y1]==0){
            return res-1;
        }
        if(x1<0||x1>=arr.length||x2<0||x2>arr.length||y1<0||y1>=arr[0].length||y2<0||y2>arr[0].length){
            return res-1;
        }
        if(x1==x2&&y1==y2){
            min= Math.min(res,min);
            return res;
        }
        if(arr[x1][y1]>arr[x2][y2]){
            return res-1;
        }
        res++;
        arr[x1][y1]=0;
        dfs(arr,x1+1,y1,x2,y2,res,min);
        dfs(arr,x1-1,y1,x2,y2,res,min);
        dfs(arr,x1,y1+1,x2,y2,res,min);
        dfs(arr,x1,y1-1,x2,y2,res,min);
        return 0;
    }
    public static int comp(int a,int b,int c,int d){
        int[] arr=new int[]{a,b,c,d};
        return Arrays.stream(arr).max().getAsInt();
    }
}
