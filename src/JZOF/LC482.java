package JZOF;

import java.util.Arrays;

/**
 * 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
 * 现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
 * 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
 * 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
 */
public class LC482 {
    public static void main(String[] args) {
        int[] b=new int[]{1,10};
        System.out.println(minDays(b,2,1));
    }
    public static int minDays(int[] bloomDay, int m, int k) {
            if(m*k>=bloomDay.length){
                return -1;
            }
            int res=0;
            if(m*k==bloomDay.length){
                res= Arrays.stream(bloomDay).max().getAsInt();
                return res;
            }
            int min=Arrays.stream(bloomDay).min().getAsInt();
            int max=Arrays.stream(bloomDay).max().getAsInt();
            while(min<max){
                int mid=min+(max-min)/2;
                if(help(bloomDay,mid,m,k)){
                    max=mid;
                }else{
                    min=mid+1;
                }
            }
            return max;

    }
    public static boolean help(int[] b,int d,int m,int k){
        int t=0;
        int i=0;
        while(i<b.length){
            int c=0;
            if(b[i]<=d){
                while(i<b.length&&c<k&&b[i]<=d){
                    c++;
                    i++;
                }
            }
            else{
                i++;
            }
            if(c==k){
                t++;
            }if(t>=m){
                return true;
            }
        }
        return false;
    }
}
