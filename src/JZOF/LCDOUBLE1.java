package JZOF;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LCDOUBLE1 {
    /*Hercy 想要为购买第一辆车存钱。他 每天 都往力扣银行里存钱。

    最开始，他在周一的时候存入 1 块钱。从周二到周日，他每天都比前一天多存入 1 块钱。在接下来每一个周一，他都会比 前一个周一 多存入 1 块钱。

    给你 n ，请你返回在第 n 天结束的时候他在力扣银行总共存了多少块钱。*/
    public static int totalMoney(int n) {
        int week = n / 7;
        int day = n % 7;
        int res = week * 28;
        for (int i = 1; i <= week; i++) {
            res = res + 7 * (i - 1);
        }
        for (int i = 1; i <= day; i++) {
            res = res + week + i;
        }
        return res;

    }

    /*给你一个字符串 s 和两个整数 x 和 y 。你可以执行下面两种操作任意次。

    删除子字符串 "ab" 并得到 x 分。
    比方说，从 "cabxbae" 删除 ab ，得到 "cxbae" 。
    删除子字符串"ba" 并得到 y 分。
    比方说，从 "cabxbae" 删除 ba ，得到 "cabxe" 。
    请返回对 s 字符串执行上面操作若干次能得到的最大得分。*/
    public static int maximumGain(String s, int x, int y) {
        int res = 0;
        char start='a';
        char end='b';
        if (x<y) {
           start='b';
           end='a';
        }
        res=gainStack(s,x,y,start,end);


        return res;
    }

    public static int gainStack(String s, int x, int y,char start, char end) {
        int res = 0;
        int max=Math.max(x,y);
        int min=Math.min(x,y);
        if (s.length() == 0) {
            return res;
        } else {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i <= s.length() - 1; i++) {
                if (stack == null || stack.isEmpty()) {
                    stack.push(s.charAt(i));
                } else if (stack.peek() == start) {
                    if (s.charAt(i) == end) {
                        stack.pop();
                        res += max;
                    } else {
                        stack.push(s.charAt(i));
                    }
                } else {
                    stack.push(s.charAt(i));
                }
            }
            if (stack.isEmpty()) {
                return res;
            } else {
                Stack<Character> stack2 = new Stack<>();
                while (!stack.isEmpty()){
                    if (stack2 == null || stack2.isEmpty()) {
                        stack2.push(stack.pop());
                    } else if (stack2.peek() == start) {
                        if (stack.peek()== end) {
                            stack.pop();
                            stack2.pop();
                            res += min;
                        } else {
                            stack2.push(stack.pop());
                        }
                    } else {
                        stack2.push(stack.pop());
                    }
                }


            }
            return res;
        }
    }

    /*
    给你一个整数 n ，请你找到满足下面条件的一个序列：
    整数 1 在序列中只出现一次。
    2 到 n 之间每个整数都恰好出现两次。
    对于每个 2 到 n 之间的整数 i ，两个 i 之间出现的距离恰好为 i 。
    序列里面两个数 a[i] 和 a[j] 之间的 距离 ，我们定义为它们下标绝对值之差 |j - i| 。
    请你返回满足上述条件中 字典序最大 的序列。题目保证在给定限制条件下，一定存在解。
    一个序列 a 被认为比序列 b （两者长度相同）字典序更大的条件是： a 和 b 中第一个不一样的数字处，a 序列的数字比 b 序列的数字大。比方说，[0,1,9,0] 比 [0,1,5,6] 字典序更大，因为第一个不同的位置是第三个数字，且 9 比 5 大。

*/
    public static int[] constructDistancedSequence(int n) {
        int s = 2 * n - 1;
        int[] res = new int[s];

        return res;
    }


    public static void main(String[] args) {

        System.out.println(maximumGain("cdbcbbaaabab", 4, 5));

    }
}
