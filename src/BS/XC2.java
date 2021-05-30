package BS;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class XC2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] st=new int[n];
        int[] et=new int[n];
        int[] price=new int[n];
        for(int i=0;i<n;i++){
            st[i]=in.nextInt();
        }
        for(int i=0;i<n;i++){
            et[i]=in.nextInt();
        }
        for(int i=0;i<n;i++){
            price[i]=in.nextInt();
        }
        System.out.println(func(st,et,price));
    }
    public static int func(int[] st,int[] et,int[] price){
        if(st.length==1){
            return price[0];
        }
        HashMap<Integer,ArrayList> m=new HashMap<>();
        for(int i=0;i<st.length;i++){
            ArrayList<Integer> list=new ArrayList<>();
            for(int j=0;j<st.length;j++){
                if(st[j]>=et[i]){
                    list.add(j);
                }
            }
            m.put(i,list);
        }
        int max=0;
        for(int i=0;i<st.length;i++){
            max=Math.max(recur(m,price,i),max);
        }
        return max;


    }
    public static  int recur(HashMap<Integer,ArrayList> m,int[] price,int key){
        ArrayList<Integer> a=m.get(key);
        if(a.size()==0){
            return price[key];
        }
        int len=m.get(key).size();
        ArrayList<Integer> t=m.get(key);
        int[] mark=new int[len];
        for(int i=0;i<len;i++){
             mark[i]=price[key]+recur(m,price,t.get(i));

        }
        return Arrays.stream(mark).max().getAsInt();
    }
}
