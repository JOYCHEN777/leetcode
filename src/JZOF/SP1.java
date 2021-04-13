package JZOF;

import java.util.Scanner;

public class SP1 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int result=legal(n)%1000000369;
        System.out.println(result);

    }
    public static int legal(int n){
        if(n<=2){
            return n;
        }
        int res=2*legal(n-1);
        int p=n-1;
        while(p>=2){
            if(n%p==0){
                res-=legal(p);

            }
            p--;
        }
        return res;
    }
    public static int gAmout(int n){
        int num=0;
        for(int i=2;i<n;i++){
            if(n%i==0){
                num++;
            }
        }
        return num;
    }
}
