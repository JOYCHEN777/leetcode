package JZOF;

import java.util.Scanner;

public class SP2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        String[] arr = n.split(";");
        System.out.print(sp2(arr[0], arr[1]));
    }

    public static String sp2(String s1, String s2) {
        int n1 = Integer.parseInt(s1, 2);
        int n2 = Integer.parseInt(s2, 2);
        long n = n1 * n2;
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.insert(0, n % 2);
            n = n / 2;
        }
        String res = sb.toString();
        return res;
    }
}
