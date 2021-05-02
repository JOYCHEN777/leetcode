package BS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AL {
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
        int res=0;
        ArrayList<Integer> list=new ArrayList<>();
        int cur=arr[x1][y1];
        dfs(arr,x1,y1,x2,y2,res,list,cur);
        if(list.size()>0){
            int max=list.stream().max((o1,o2)->o2-o1).get();
            int[] map=new int[list.size()];
            for(int i=0;i<map.length;i++){
                map[i]= list.get(i);
            }
            Arrays.sort(map);
            return map[0];
        }
        return -1;
    }
    public static void dfs(int[][] arr, int x1, int y1, int x2, int y2, int res, ArrayList<Integer> list,int cur){
        if(x1<0||x1>=arr.length||x2<0||x2>arr.length||y1<0||y1>=arr[0].length||y2<0||y2>arr[0].length){
            return ;
        }
        if(arr[x1][y1]<cur){
            arr[x1][y1]=0;
            return;
        }
        if(arr[x1][y1]==0){
            return ;
        }
        if(arr[x1][y1]>arr[x2][y2]){
            arr[x1][y1]=0;
            return ;
        }
        if(x1==x2&&y1==y2){
           list.add(res);
            return ;
        }
        cur=arr[x1][y1];
        arr[x1][y1]=0;
        res++;
        dfs(arr,x1+1,y1,x2,y2,res,list,cur);
        dfs(arr,x1-1,y1,x2,y2,res,list,cur);
        dfs(arr,x1,y1+1,x2,y2,res,list,cur);
        dfs(arr,x1,y1-1,x2,y2,res,list,cur);
    }
}
