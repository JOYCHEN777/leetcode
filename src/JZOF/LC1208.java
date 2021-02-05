package JZOF;

import java.util.LinkedList;
import java.util.Queue;

public class LC1208 {
    /*
    * 给你两个长度相同的字符串，s 和 t。
将 s中的第i个字符变到t中的第 i 个字符需要|s[i] - t[i]|的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
用于变更字符串的最大预算是maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
*/
    public static int equalSubstring(String s, String t, int maxCost) {
        //快了一丢丢
        int res = 0;
        int[] diff = new int[s.length()+1];
        for (int i = 1; i <= s.length(); i++) {
            diff[i] =diff[i-1]+ Math.abs(s.charAt(i-1) - t.charAt(i-1));
        }
        //int l=0;
        int r=1;
        for(int i=0;i<diff.length;i++){
            while(r<diff.length&&diff[r]-diff[i]<=maxCost){
                r++;
            }
            res=Math.max(res,r-1-i);
        }
        return res;
    }
    public static void main(String[] args){
        String s="krrgw";
        String t="zjxss";
        int cost=19;
        System.out.println(equalSubstring(s,t,cost));
    }
}
/* 太慢了
public static int equalSubstring(String s, String t, int maxCost) {
        int res = 0;
        int[] diff = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int i = 0;
        int temp=0;
        while (sum <=maxCost && i < diff.length) {
            if(diff[i]>maxCost){
                sum=0;
                temp=0;
                while(!queue.isEmpty()){
                    queue.poll();
                }
                i++;
            }
            else if (sum + diff[i] <= maxCost) {
                queue.offer(diff[i]);
                sum += diff[i];
                temp++;
                i++;
            } else {
                int out=queue.poll();
                sum-=out;
                temp--;
            }
            res=Math.max(temp,res);
        }
        return res;
    }
* */