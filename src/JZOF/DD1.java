package JZOF;

import java.util.Scanner;

public class DD1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] pt = new int[T];
        int[] rt = new int[T];
        //int[] all = new int[T];
        for (int i = 0; i < T; i++) {
            pt[i] = in.nextInt();
            rt[i] = in.nextInt();
            //all[i] = pt[i] + rt[i];
        }
        System.out.println(time(pt, rt));
    }

    public static int time(int[] pt, int[] rt) {
        //int res=0;

        for (int i = 0; i < pt.length; i++) {
           for(int j=i+1;j<pt.length;j++){
               if(pt[j]<pt[i]){
                   int p=pt[j];
                   pt[j]=pt[i];
                   pt[i]=p;
                   int r=rt[j];
                   rt[j]=rt[i];
                   rt[i]=r;
               }
           }
        }
        int pMax=pt[pt.length-1];
        int sum=pt[0]+rt[0];
        int left=pMax-sum;
        for(int i=1;i<pt.length;i++){
            sum=Math.max(sum,pt[i]);
            sum+=rt[i];
        }
        return sum;

    }
}
