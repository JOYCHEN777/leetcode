package JZOF;

import java.util.Scanner;

public class TX4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int i = 0; i < t; i++) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            System.out.println(func(s1, s2));
        }
    }

    public static String func(String s1, String s2) {
        if (s1.length() % 2 != 0) {
            if (compare(s1,s2)) {
                return "YES";
            } else {
                return "NO";
            }
        }


        boolean res=func2(s1,s2);
        if(res==true){
            return "YES";
        }
        return  "NO";
    }
    public static boolean compare(String s1,String s2){
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static boolean func2(String s1, String s2) {
        if (s1.length() % 2 != 0 || s1.length() <= 0) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int len = s1.length() / 2;
        String s1l = s1.substring(0, len);
        String s1r = s1.substring(len);
        String s2l = s2.substring(0, len);
        String s2r = s2.substring(len);
        if (s1l.equals(s2r) && s1r.equals(s2l)) {
            return true;
        }
        return func2(s1r, s2l)&&func2(s1l, s2r);

    }
}
