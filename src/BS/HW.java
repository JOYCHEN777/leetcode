package BS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HW {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int m=in.nextInt();
        int n=in.nextInt();
        int[][] arr= new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=in.nextInt();
            }
        }
        if(m==1&&n==1){
            System.out.println(arr[0][0]);
        }else{
            List<Integer> res=new ArrayList<>();
            bfs(arr,res,0,0,0,-1);
            int min=Collections.min(res);
            System.out.println(min);
        }

    }
    public static void bfs(int[][] arr,List<Integer> res,int i,int j,int step,int last){
        if(i<0||i>=arr.length||j<0||j>=arr[0].length){
            return;
        }
        if(arr[i][j]==-1){
            return;
        }
        step+=arr[i][j];
        if(last==arr[i][j]){
            step--;
        }
        last=arr[i][j];
        arr[i][j]=-1;
        if(i==arr.length-1&&j==arr[0].length-1){
            res.add(step);

        }
        bfs(arr,res,i+1,j+1,step,last);
        bfs(arr,res,i+1,j,step,last);
        bfs(arr,res,i+1,j-1,step,last);
        bfs(arr,res,i-1,j+1,step,last);
        bfs(arr,res,i-1,j,step,last);
        bfs(arr,res,i-1,j-1,step,last);
        bfs(arr,res,i,j+1,step,last);
        bfs(arr,res,i,j-1,step,last);

    }
}
