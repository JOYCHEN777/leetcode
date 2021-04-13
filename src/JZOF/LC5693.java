package JZOF;

import java.util.Arrays;

/**
 * 给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
 * 混合字符串 由小写英文字母和数字组成。
 * 输入：s = "abc1111"
 * 输出：-1
 * 解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
 */
public class LC5693 {
    public static int secondHighest(String s) {
        int[] mark=new int[10];
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                int num=s.charAt(i)-'0';
                mark[num]++;
            }
        }
        int[] a=new int[10];
        Arrays.fill(a,-1);
        int p=0;
        for(int i=9;i>=0;i--){
            if(p>=2){
                break;
            }
            if(mark[i]>=1){
                a[p]=i;
                p++;
            }

        }
        return a[1];
    }
    public static void main(String[] args){
        String s=new String("abc1111123902");
        System.out.println(secondHighest(s));

    }
}
