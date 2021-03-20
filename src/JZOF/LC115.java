package JZOF;

/**
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 *
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
 * （例如，"ACE"是"ABCDE"的一个子序列，而"AEC"不是）
 * 题目数据保证答案符合 32 位带符号整数范围。

 */
public class LC115 {
    public static int numDistinct(String s, String t) {
        int sLen=s.length();
        int tLen=t.length();
        int[][] dp=new int[tLen+1][sLen+1];
        for(int i=0;i<sLen+1;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<tLen+1;i++){
            for (int j=1;j<sLen+1;j++){
                if(s.charAt(j-1)==t.charAt(i-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i][j-1];
                }else{
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[tLen][sLen];
    }
    public static void main(String[] args){
        String s="ababc";
        String t="ab";
        System.out.println(numDistinct(s,t));
    }
}
