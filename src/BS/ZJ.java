package BS;

import java.util.Scanner;

public class ZJ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            System.out.println(fun(s));
        }

    }

    public static String fun(String s) {
        if (s.length() <= 2) {
            return s;
        }
        char[] c = s.toCharArray();
        boolean flag = false;
        int t = 0;
        int count = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(c[0]);
        for (int i = 1; i < c.length; i++) {
            if (c[i] != c[i - 1]) {
                sb.append(c[i]);
                count = 1;
                if(i+1<c.length&&c[i]!=c[i+1]){
                    flag=false;
                }
                continue;
            } else {
                count++;
                if (count == 2&&flag==true) {
                    while(i<c.length-1&&c[i]==c[i+1]){
                        i++;
                    }
                    flag=false;
                    count=1;
                }else if(count==2&&!flag){
                    sb.append(c[i]);
                    while(i<c.length-1&&c[i]==c[i+1]) {
                        i++;
                    }
                    flag =true;
                    count =1;
                }
            }
        }
        return sb.toString();
    }

}
