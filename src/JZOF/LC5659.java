package JZOF;

public class LC5659 {
    /*
    * 给你一个只包含字符 'a'，'b' 和 'c' 的字符串 s ，你可以执行下面这个操作（5 个步骤）任意次：
    选择字符串 s 一个 非空 的前缀，这个前缀的所有字符都相同。
    选择字符串 s 一个 非空 的后缀，这个后缀的所有字符都相同。
    前缀和后缀在字符串中任意位置都不能有交集。
    前缀和后缀包含的所有字符都要相同。
    同时删除前缀和后缀。
    请你返回对字符串 s 执行上面操作任意次以后（可能 0 次），能得到的 最短长度 。*/
    public static int minimumLength(String s) {
        int l=0;
        int r=s.length()-1;
        while(s.charAt(l)==s.charAt(r)&&l<r){
            char temp=s.charAt(l);
            while (l<r&&s.charAt(l+1)==temp){
                l=l+1;
            }
            while(l<r&&s.charAt(r-1)==temp){
                r=r-1;
            }
            if(l==r){
                return 0;
            }
            l++;
            r--;
        }
        return r-l+1;
    }
    public static void main(String[] args){
        String s="aaaa";
        System.out.println(minimumLength(s));
    }
}
