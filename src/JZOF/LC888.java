package JZOF;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC888 {
    /*爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
    因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。
    （一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
    返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，
    ans[1]是 Bob 必须交换的糖果棒的大小。
    如果有多个答案，你可以返回其中任何一个。保证答案存在。
    */
    public static int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            sumB += B[i];
        }
        Set<Integer> map = new HashSet<>();
        for (int num : B) {
            map.add(num);}
        int dif = (sumA - sumB) / 2;
        for(int i=0;i<A.length;i++){
            if(map.contains(A[i]-dif)){
                int[] res = new int[2];
                res[0]=A[i];
                res[1]=A[i]-dif;
                return res;
            }
        }

            return null;
        }
        public static void main (String[]args){
            int[] A = new int[]{35, 17, 4, 24, 10};
            int[] B = new int[]{63, 21};
            System.out.println(fairCandySwap(A, B)[0]);
            System.out.println(fairCandySwap(A, B)[1]);
        }
    }
/* 二分查找
       for(int i=0;i<A.length;i++){
           int l=0;
           int r=B.length-1;
           while(l<=r){
               int m=(l+r)/2;
               if(B[m]>A[i]-dif){
                   r=m-1;
               }else if(B[m]<A[i]-dif){
                   l=m+1;
               }
               else{
                   res[0]=A[i];
                   res[1]=B[m];
                   return res;
               }
           }
       }*/