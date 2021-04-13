package JZOF;


/**
 * 小美想要为小团摆一行积木，每个积木上都有一个0-9的数字。现在已经摆好了 n 块积木，小美可以把其中一块积木替换成任意一块积木（也可以不替换），使得积木看起来更符合小美的审美。请你帮小美看看，替换后最好看的积木是什么样的。
 * <p>
 * 摆好后的积木上面的数字，从左到右会形成一个数字串（由数字组成的字符串）。小美会根据这个数字串来评判积木的好看程度，小美有两条审美标准：
 * <p>
 * ①回文数字串相比于非回文数字串更符合小美的审美。例如：12321、2332是回文数字串，而12212、2121不是回文数字串。
 * <p>
 * ②数字串形成的数字更小更好看。例如：1312比1313更好看，0102比1102更好看。
 * <p>
 * 小美会按照她的审美标准来判断两个数字串哪个更好看，即先按照审美标准①判断，若无法判断再按审美标准②判断。
 * <p>
 * 第一行一个数 T，表示一共有 T 组测试数据。(1 ≤ T ≤ 100)。
 * <p>
 * 接下来 T 组数据，每组数据两行，
 * <p>
 * 第一行一个数 n，表示有 n 块积木。(1 ≤ n ≤ 20000)。
 * <p>
 * 第二行 n 个数字，第 i 块积木上的数字是 si。(si是0-9的数字)。
 */

import java.util.Scanner;

public class Main {
    public static int beautyNumber(int n, String s) {
        int count = 0;
        int mark = 0;
        char dif = '0';
        if (n == 1) {
            return Integer.parseInt(s);
        } else {
            for (int i = 0; i < n / 2 + 1; i++) {
                if (s.charAt(i) != s.charAt(n - 1 - i)) {
                    dif = s.charAt(i);
                    mark = n - 1 - i;
                    count++;
                }
            }
            if (count == 0) {
                return Integer.parseInt(s);
            }
            if (count == 1) {
                StringBuffer sb = new StringBuffer(s);
                sb.setCharAt(mark, dif);
                return Integer.parseInt(sb.toString());
            }
            if (s.charAt(0) == '0') {
                StringBuffer sb1 = new StringBuffer(s);
                sb1.delete(0, 1);
                return Integer.parseInt(sb1.toString());
            }
            int index = 0;
            while (index < n && s.charAt(index) == 0) {
                index++;
            }
            if (index == n) {
                return 0;
            } else {
                StringBuffer sb2 = new StringBuffer(s);
                sb2.setCharAt(index, '0');
                return Integer.parseInt(sb2.toString());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("enter:");
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            String length = in.next();
            int len = Integer.parseInt(length);
            String s = in.nextLine();
            System.out.println(beautyNumber(len, s));
        }


    }
}
