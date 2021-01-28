package JZOF;

import java.io.CharArrayWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.*;

public class LC3 {
    public static int lengthOfLongestSubstring(String s) {
        //用一个数组来记录最后出现的位置！
        int[] last = new int[128];
        for (int i = 0; i <= s.length() - 1; i++) {
            last[i] = -1;
        }
        int len = s.length();
        int res = 0;
        int start = 0;
        for (int i = 0; i <= len - 1; i++) {
            //把char转成int做index查找
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }
        return res;
    }
}




        /* attempt 2, more ugly
        public static int lengthOfLongestSubstring(String s) {
        if(s.length()<=1){
            return s.length();
        }
        int res=1;
        List<Character> list=new ArrayList<>() ;
        list.add(s.charAt(0));
        for(int i=1;i<=s.length()-1;i++){
            if(list.contains(s.charAt(i))||i==s.length()-1){
                res=Math.max(res,list.size());
                int x=list.indexOf(s.charAt(i));
                list=list.subList(x+1,list.size());

            }
            if(i==s.length()-1){
                res=Math.max(res,list.size()+1);
            }
            list.add(s.charAt(i));
        }
        return res;
    }
    public static void main(String[] args){
        String s="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

    }
}*/
/*给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。*/
    /*public static int lengthOfLongestSubstring(String s){
        int res=1;
        for(int i=0;i<=s.length()-2;i++){
            int temp=1;
            Set<Character> c=new HashSet<>();
            c.add(s.charAt(i));
            for(int j=i+1;j<=s.length()-1;j++){
                if(!c.contains(s.charAt(j))){
                    c.add(s.charAt(j));
                    temp++;
                }else{
                    break;
                }
            }
            res=Math.max(res,temp);
        }
        return res;
    }
    public static void main(String[] args){
        String s="abcabcdeacc";
        System.out.println(lengthOfLongestSubstring(s));

    }
}*/
