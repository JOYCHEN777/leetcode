package JZOF;

import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 */
public class LC227 {
    public static int calculate(String s) {
        Stack<Integer> in = new Stack<>();
        //Stack<Integer> out = new Stack<>();
        int num = 0;
        int res = 0;
        int pre = 1;
        char op = '#';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            } else if (Character.isDigit(s.charAt(i))) {
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = 10 * num + s.charAt(i) - '0';
                    i++;
                }
                i--;
                if (op != '#') {
                    num = (op == '*') ? num * in.pop() : in.pop() / num;
                    op='#';
                }
                in.push(num);
            } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                op = s.charAt(i);
                num=0;
            } else {
                num=0;
                res += pre * in.pop();
                pre = s.charAt(i) == '+' ? 1 : -1;
            }

        }
        return res + pre * in.pop();
    }
    public static void main(String[] args){
        int res=calculate("24*312+22");
        int res2=24*312+22;
        System.out.println(res);
        System.out.println(res2);
    }
}
