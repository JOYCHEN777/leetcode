package JZOF;



/**
 * 小A的家门口有一排树，每棵树都有一个正整数的高度。
 * 由于树的高度不同，来到小A家的朋友都觉得很难看。
 * 为了将这些树高度变得好看，小A决定对其中某些树施展魔法，
 * 具体来说，每施展一次魔法，可以把一棵树的高度变成任意正整数（可以变高也可以变低）。
 * 小A认为，这排树如果能构成等差为x的等差数列就好看了。
 * 但是小A不想施展太多次魔法，他想知道最少施展魔法的次数。
 * 形式上来说，小A家门口一共有n棵树，第i棵树高度为ai。小A最后的目标为对于任意2≤i≤n，ai-ai-1=x
 */
import java.util.Scanner;
public class DD2 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int x=in.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        System.out.println(magic(arr,x));
    }
    public static int magic(int[] arr,int x){
        if(arr.length<=1){
            return 0;
        }
        int res=arr.length;
        for(int i=0;i<arr.length;i++){
            int count=0;
            int index=i;
            int n=arr[i];
            for(int j=0;j<arr.length;j++){
                if(n+(j-i)*x<=0){
                    count=arr.length;
                }

                else if(arr[j]!=n+(j-i)*x){
                    count++;
                }

            }
            res=Math.min(count,res);
        }
        return res;
    }
}
