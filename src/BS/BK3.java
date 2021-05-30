package BS;

import java.util.Scanner;

public class BK3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        System.out.println(func(arr,k));
    }
    public static int func(int[] arr,int k){
        int res=1;
        int[] big=new int[arr.length+1];
        big[1]= arr[0]>k?1:0;
        int[] small=new int[arr.length+1];
        small[1]= arr[0]>k?0:1;
        for(int i=2;i<arr.length+1;i++){
            int b=arr[i-1]>k?1:0;
            big[i]=big[i-1]+b;
            int s=arr[i-1]>k?0:1;
            small[i]=small[i-1]+s;
        }
        //int[][] dp=new int[arr.length][arr.length];
        for(int i=0;i<arr.length+1;i++){
            for(int j=i+1;j<arr.length+1;j++){
                int bn=big[j]-big[i];
                int sn=small[j]-small[i];
                if(bn>sn){
                    res=Math.max(j-i,res);
                }
            }
        }
        return res;
    }
}
