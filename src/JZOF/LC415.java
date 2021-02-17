package JZOF;

public class LC415 {
    /*给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。*/
    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int sum = 0;
        StringBuilder sb=new StringBuilder();
        while (i >= 0 || j >= 0||sum!=0) {
            int n1 = 0;
            int n2 = 0;
            if (i >= 0) {
                n1 = num1.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                n2 = num2.charAt(j) - '0';
                j--;
            }
            sum += n1 + n2;
            sb.append(sum%10);
            sum=sum/10;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args){
        String num1="9";
        String num2="10";
        System.out.println(addStrings(num1,num2));
        System.out.println(123456789+23);
    }
}
