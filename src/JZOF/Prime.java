package JZOF;

import java.util.ArrayList;
import java.util.List;

public class Prime {
    /**
     * 给定一个n，输出小于等于n的所有质数
     * 质数：1或者自己整除
     * 0->n 2->n/2 O(n^2)
     */
    /**
     * 如果存在比 Math.sqrt(i) 更大的因子 d
     * 说明 i/d= m ; m也是i的一个因子
     * n n/2 Math.sqrt(n)
     */
    public static List<Integer> isPrime(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(2);
        for (int i = 3; i <= n; i+=2) {
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = isPrime(10);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
