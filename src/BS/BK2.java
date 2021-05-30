package BS;

import java.util.Arrays;
import java.util.Scanner;

public class BK2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(func(arr));
    }

    public static int func(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        int res = 0;
        int i = 0;
        int j = 0;
        while (j < arr.length) {

            while (j < arr.length && arr[j] == arr[i]) {
                j++;
            }
            res = Math.max(res, j - i);
            i = j;

        }
        return res;
    }
}
