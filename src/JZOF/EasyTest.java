package JZOF;

import java.util.Scanner;

public class EasyTest {
    public static void main(String[] args){
        //Scanner in=new Scanner(System.in);
        int N=10;
        System.out.println(happy(N));
        EasyTest e=new EasyTest();
        Class a=e.getClass();
        System.out.println(a);
        ClassLoader b=a.getClassLoader();
        System.out.println(b);

    }
    public static  int happy(int n){
        if(n<=22||n%10==0||n%10==1||n%10==n/10){
            return n;
        }
        return -1;
    }
}