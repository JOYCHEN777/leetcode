package JZOF;

import java.util.Scanner;

public class PDD4 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int M=in.nextInt();
        System.out.println(amountOfZero(N,M));
    }
    public static int amountOfZero(int n,int m){
        int amount=1;
        int t=n;
        while(t>1){
            amount*=t;
            t--;
        }
        StringBuilder s=new StringBuilder();

        while (amount!=0){
            int c=amount%m<10?amount%m:1;
            s.insert(0,c);

            amount=amount/m;
        }
       int res=0;
        String str=s.toString();
        int i=str.length()-1;
        while(i>=0&&str.charAt(i)=='0'){
            res++;
            i--;
        }

        return res;
    }

}
