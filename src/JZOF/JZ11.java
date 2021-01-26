package JZOF;

/*输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 */
public class JZ11 {
    public int numberOfOne(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n=n&(n-1);//n-1使得n从最右一位1开始取反，所以n&n-1的结果是让1从最右那位1开始变成0。这种操作可以做几次，就有几个1。
        }
        return res;
    }

}
