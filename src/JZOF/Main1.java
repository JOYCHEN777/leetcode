package JZOF;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        String s = "FTFFFTFFFF";
        System.out.println(minimumMP(3,10,s));
    }

    public static int minimumMP(int min, int n, String s) {

        char[] ch = s.toCharArray();
        int count = 0;
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (ch[i] == 'F') {
                count++;
            } else {
                count = 0;
            }
            if (count >= 3) {
                num++;
                count = 0;
            }


        }
        return min * num;
    }
}
