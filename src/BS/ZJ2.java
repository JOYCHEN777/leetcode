package BS;

import java.util.Scanner;

public class ZJ2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int D=in.nextInt();
        int[] loc=new int[N];
        for(int i=0;i<N;i++){
            loc[i]=in.nextInt();
        }
        System.out.println(fun(loc,D));

    }
    public static long fun(int[] loc,int t){
        if(loc.length<3){
            return 0;
        }
        if(loc.length==3&&loc[2]-loc[0]<=t){
            return 1;
        }
        long res=0;
        int r=2;
        for(int i=0;i<loc.length-2;i++){
            if(loc[r]-loc[i]>t){
                continue;
            }
            while(r<loc.length&&loc[r]-loc[i]<=t){
                r++;
            }
            long n=r-i-2;
            res+=((n+1)*n/2);
            r--;

        }

        return res%99997867;
    }
}
