package JZOF;

import java.util.Scanner;

public class PA1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        s=s.replace(';',',');
        String[] str=s.split(",");

        //The each subject score of  No.17140216 is 80.85,90.5,100
        StringBuilder sb=new StringBuilder("The each subject score of  No."+str[0]+" is ");
        sb.append(format(str[1]));
        sb.append(',');
        sb.append(format(str[2]));
        sb.append(',');
        sb.append(format(str[3]));
        String res=sb.toString();
        System.out.println(res);

    }
    public static String format(String s){
        StringBuilder sb=new StringBuilder();
        int count=0;
        int index=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='.'){
                index=i;
            }
        }
        int len=s.length();
        if(index>0){
            len=Math.min(s.length(),index+2+1);
        }
        for(int i=0;i<len;i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
