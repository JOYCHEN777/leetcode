package BS;

import java.util.Arrays;
import java.util.Scanner;

public class Bk4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] orange = new int[n];
        for (int i = 0; i < n; i++) {
            orange[i] = in.nextInt();
        }
        Arrays.sort(orange);
        boolean[] res = new boolean[q];
        for (int i = 0; i < q; i++) {
            int target = in.nextInt();
            res[i] = func(orange, target);
        }
        for (int i = 0; i < q; i++) {
            if (res[i]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean func(int[] arr, int t) {
        if (arr.length < 1) {
            return false;
        }
        if (arr.length == 1) {
            if (arr[0] == t) {
                return true;
            } else {
                return false;
            }
        }
        int sum = Arrays.stream(arr).sum();
        if (t == sum) {
            return true;
        }
        if (t > sum) {
            return false;
        }
        int av = sum / arr.length;
        int s = 0;
        while (s < arr.length && arr[s] <= av) {
            s++;
        }
        if(s==arr.length){
            return false;
        }
        int b = arr.length - s;
        int[] sarr = new int[s];
        int[] barr = new int[b];
        for (int i = 0; i < s; i++) {
            sarr[i] = arr[i];
        }
        for (int i = 0; i < b; i++) {
            barr[i] = arr[i + s];
        }
        return func(sarr, t) || func(barr, t);

    }

}
