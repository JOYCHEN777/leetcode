package JZOF;

import java.util.Arrays;

public class LC5730 {

    /***
     * 给你一个下标从 0 开始的字符串 s ，它的 偶数 下标处为小写英文字母，奇数 下标处为数字。
     * 定义一个函数 shift(c, x) ，其中 c 是一个字符且 x 是一个数字，函数返回字母表中 c 后面第 x 个字符。
     * 比方说，shift('a', 5) = 'f' 和 shift('x', 0) = 'x' 。
     * 对于每个 奇数 下标 i ，你需要将数字 s[i] 用 shift(s[i-1], s[i]) 替换。
     * 请你替换所有数字以后，将字符串 s 返回。题目 保证 shift(s[i-1], s[i]) 不会超过 'z' 。
     */
    public static void main(String[] args) {
        int[] arr = new int[]{209, 209, 209, 209,
                209, 209, 209, 209, 209, 209, 209,
                209, 209, 209, 209, 209, 209, 209, 209,
                209, 209, 209, 209, 209, 209, 209, 209,
                209, 209, 209, 209, 209, 209, 209, 209,
                209, 209, 209, 209, 209, 209, 209, 209};
        System.out.println(maximumElementAfterDecrementingAndRearranging(arr));
    }

    public static String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                sb.append(s.charAt(i));
            } else {
                sb.append(func(s.charAt(i - 1), s.charAt(i)));
            }

        }
        return sb.toString();


    }

    public static char func(char c, char n) {
        int num = n - '0';
        int dif = c + num;
        char res = (char) dif;
        return res;
    }

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);
        int[] dp=new int[len];
        dp[0]=1;
        for(int i=1;i<len;i++){
            dp[i]=Math.min(dp[i-1]+1,arr[i]);
        }
        return dp[len-1];
    }
}
