package BS;

import java.util.Scanner;

public class HW3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int M=in.nextInt();
        int N=in.nextInt();
        int x=in.nextInt();
        in.nextLine();
        String[] arr=new String[N];
        for(int i=0;i<N;i++){
            arr[i]=in.nextLine();
        }
    }
}
