package JZOF;

/*我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

比如n=3时，2*3的矩形块有3种覆盖方法：*/
public class JZ10 {
    public int squareCover(int n) {
        if (n < 1) {
            return 0;

        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return squareCover(n-2)+squareCover(n-1);
    }

}
