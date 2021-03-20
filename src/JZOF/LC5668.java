package JZOF;

public class LC5668 {
    /*
    * 当一个字符串 s 包含的每一种字母的大写和小写形式 同时 出现在 s 中，
    * 就称这个字符串 s 是 美好 字符串。比方说，"abABB" 是美好字符串，
    * 因为 'A' 和 'a' 同时出现了，且 'B' 和 'b' 也同时出现了。
    * 然而，"abA" 不是美好字符串因为 'b' 出现了，而 'B' 没有出现。
给你一个字符串 s ，请你返回 s 最长的 美好子字符串 。
* 如果有多个答案，请你返回 最早 出现的一个。如果不存在美好子字符串，请你返回一个空字符串。*/
    public String longestNiceSubstring(String s) {
        int[] mark=new int[s.length()];
        for(int i=0;i<s.length();i++){
            mark[i]=s.charAt(i);
        }

        return "";
    }
}
