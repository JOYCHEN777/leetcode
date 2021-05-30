package JZOF;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TT {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2};
        int[] b = new int[]{2, 1};
        System.out.println();

    }

    public static int validateStackSequences(int num) {
        String s = Integer.toString(num);
        int len = s.length();
        if (len <= 1) {
            return len;
        }
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < len+1; i++) {
            if (s.charAt(i - 2) == '0') {
                dp[i] = dp[i - 1];
            } else {
                int b = s.charAt(i-1) - '0';
                int c = s.charAt(i - 2) - '0';
                if (b + 10 * c <= 25) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[len];
    }
}
