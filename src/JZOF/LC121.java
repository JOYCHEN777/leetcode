package JZOF;

/**
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
 * 设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

 */
public class LC121 {
    public static int maxProfit(int[] prices) {
        int min=prices[0];
        int max=0;
        for(int i=1;i<prices.length;i++){
            max=Math.max(max,prices[i]-min);
            min=Math.min(min,prices[i]);
        }
        return max;
    }
    public static void main(String[] args){
        int[] p=new int[]{9,2,10,99};
        System.out.println(maxProfit(p));
    }
}
