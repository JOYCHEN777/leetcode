package JZOF;

/*给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

保证base和exponent不同时为0*/
public class JZ12 {
    public double Power(double base, int exponent) {
        if (base == 0 && exponent > 0) {
            return 0;
        }

        //如果是负数幂，把底数做倒数处理，幂数按正数操作
        if (exponent < 0) {
            exponent = -exponent;
            base = 1 / base;
        }
        double x= base;//第一项，2^0=1
        double res = 1.0;//初始化结果为1
        //当幂不为0时候进入循环
        while (exponent != 0) {
            //如果最右一位为1，说明此位置要乘，进入循环
            if (((exponent & 1) % 2) != 0) {
                res = res * x;
            }
            //右移
            exponent = exponent >> 1;
            //底数每次变化
            x = x * base;
        }
        return res;
    }
}
