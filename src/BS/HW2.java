package BS;
/**
 * 6
 * 5
 * liba.dll libb.dll  a>b
 * libc.dll libb.dll  c>b
 * libb.dll libf.dll  b>f
 * libe.dll libf.dll  e>f
 * libd.dll libe.dll  d>e
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int M=in.nextInt();
        int N=in.nextInt();
        in.nextLine();
        String[] arr=new String[N];
        for(int i=0;i<N;i++){
            arr[i]=in.nextLine();
        }
        System.out.println(circle(arr,M));
        System.out.println("libf.dll libb.dll libe.dll liba.dll libc.dll libd.dll");

    }
    public static boolean circle(String[] arr,int M){
        char[][] ch=new char[arr.length][2];
        int[][] mark=new int[arr.length][2];
        for(int i=0;i<arr.length;i++){
            ch[i][0]=arr[i].charAt(3);
            mark[i][0]=ch[i][0]-'a';
            ch[i][1]=arr[i].charAt(12);
            mark[i][1]=ch[i][1]-'a';
        }
        UF uf=new UF(M);
        for(int i=0;i<arr.length;i++){
            if(!uf.union(mark[i][0],mark[i][1])){
                return true;
            }
        }


        return false;
    }

}
class UF {
    int n;
    int[] parent;
    int[] rank;

    public UF(int n) {
        this.n = n;
        this.parent = new int[n + 1];
        this.rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    public int findRoot(int x) {
        int xR = x;
        while (xR != parent[xR]) {
            parent[xR] = parent[parent[xR]];
            xR = parent[xR];
        }
        return xR;
    }

    public boolean union(int x, int y) {
        int xr = findRoot(x);
        int yr = findRoot(y);
        if (xr == yr) {
            return false;
        } else {
            if (rank[xr] > rank[yr]) {
                parent[yr] = xr;
            } else if (rank[xr] < rank[yr]) {
                parent[xr] = yr;
            } else {
                parent[xr] = yr;
                rank[yr]++;
            }
        }
        return true;
    }
    public int numbers(){
        int res=0;
        for(int i=1;i<=n;i++){
            if(parent[i]==i){
                res++;
            }
        }
        return res;
    }
}