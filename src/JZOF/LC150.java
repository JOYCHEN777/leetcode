package JZOF;

import java.util.Queue;
import java.util.Stack;

/**
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括+、-、*、/。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * <p>
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 */
public class LC150 {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> in = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int num1 = in.pop() + in.pop();
                in.push(num1);
            } else if (tokens[i].equals("-")) {
                int num2 = (-in.pop()) + in.pop();
                in.push(num2);
            } else if (tokens[i].equals("*")) {
                int num3 = in.pop() * in.pop();
                in.push(num3);
            } else if (tokens[i].equals("/")) {
                int temp = in.pop();
                int num4 = in.pop() / temp;
                in.push(num4);
            } else {
                int num = Integer.parseInt(tokens[i]);
                in.push(num);

            }
        }

        return in.pop();
    }

    public static void main(String[] args) {
        String[] t = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(t));
    }
}
