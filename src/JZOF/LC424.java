package JZOF;

public class LC424 {
    /*
    给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换k次。
    在执行上述操作后，找到包含重复字母的最长子串的长度。
    注意：字符串长度 和 k 不会超过10000。
     */
    public static int characterReplacement(String s, int k) {
        if(s==null||s.length()<1){
            return 0;
        }
        int res = 1;
        for (int i = 0; i < s.length(); i++) {
            int temp = 1;
            int mark = k;
            int j = i + 1;
            while (j <=s.length()) {
                if (j < s.length() && s.charAt(j) == s.charAt(i)) {
                    temp++;
                    j++;
                } else if (j < s.length() && mark > 0) {
                    temp++;
                    j++;
                    mark--;
                } else {
                    if(mark>0){
                        temp=temp+Math.min(mark,i);
                    }
                    res = Math.max(temp, res);
                    if(j==s.length()){
                        return res;
                    }
                    break;
                }
            }

        }
        return res;
    }
    public static void main(String[] args){
        String s="BA";
        int k=0;
        System.out.println(characterReplacement(s,k));
    }


}
