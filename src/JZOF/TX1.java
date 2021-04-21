package JZOF;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TX1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] user = new int[n + 1];
        int l = 0;
        for (int i = 1; i < n + 1; i++) {
            int t = in.nextInt();
            user[i] = t;
            l = Math.max(l, t);
        }
        int max = l * k;

        String[] mark = new String[max + 1];
        for (int i = 1; i < n + 1; i++) {
            int t = user[i];
            int count = 1;

            while (count * t < max + 1) {
                int index = count * t;
                if (mark[index] == null) {
                    mark[index] = String.valueOf(i);
                } else {
                    mark[index] += ("," + i);
                }
                count++;
            }
        }
        int sum = 0;
        //ArrayList<Integer> arr=new ArrayList<>();
        for (int i = 1; i < mark.length; i++) {
            if (sum >= k) {
                break;
            }
            if (mark[i] != null) {
                String[] str = mark[i].split(",");
                for (int j = 0; j < str.length; j++) {
                    System.out.println(Integer.parseInt(str[j]));
                    sum++;
                    if (sum >= k) {
                        break;
                    }
                }

            }

        }
    }
}