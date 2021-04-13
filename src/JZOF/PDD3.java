package JZOF;

import javax.print.DocFlavor;
import java.util.Scanner;

public class PDD3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int K = in.nextInt();
        String s = in.nextLine();
        if (s.length()<2*K||s.length()%K!=0){
            System.out.println(-1);
        }else if(K==1){
            System.out.println(s);
        }
        else{
            System.out.println(magicString(s,K));
        }
    }

    public static String magicString(String s,int k){
        boolean inc=false;
        int sum=0;
        for(int i=0;i<s.length();i++){
            sum+=s.charAt(i)-'a';
        }
        StringBuilder sb=new StringBuilder(s.substring(0,s.length()/k));

        return "";
    }
}
