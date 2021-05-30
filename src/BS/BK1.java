package BS;

import java.util.HashMap;
import java.util.Scanner;

public class BK1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        in.nextLine();
        HashMap<String,int[]> map=new HashMap<>();
        for(int i=0;i<n;i++){
            String s=in.nextLine();
            String[] str=s.split(" ");
            int[] data=new int[2];
            data[0]=Integer.parseInt(str[1]);
            data[1]=Integer.parseInt(str[2]);
            map.put(str[0],data);
        }
        int res=0;
        boolean e=true;
        for(int i=0;i<m;i++){
            String s=in.nextLine();
            String[] str=s.split(" ");
            int num=Integer.parseInt(str[1]);
            int unit=money(str[0],num,map);
            if(unit==-1){
                System.out.println(-(i+1));
                e=false;
                break;
            }else{
                res+=unit;
            }

        }
        if(e){
            System.out.println(res);
        }
    }
    public static  int money(String s,int n, HashMap<String,int[]> map){
        int[] d=map.get(s);
        if(n>d[1]){
            return -1;
        }
        return n*d[0];
    }
}
