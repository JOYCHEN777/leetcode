package JZOF;

import javax.swing.tree.TreeNode;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 假设在一条无限长的道路上盖房子，第一个月在某个点盖一个红房子，
 * 之后每个月，都会在上一次盖的新房子的左边盖一个绿房子，
 * 右边盖一个红房子。（假设两个房子之间的空间无限大，可以一直在中间盖房子）
 * 用字符'R'表示红房子，用字符'G'表示绿房子。
 * 输入一个n(1≤n≤12)，表示过了n个月，打印出当前道路上房子从左到右的排列。
 */
//输入2：GRR
//输入5：GGRGGRRGGGRRGRRRGGRGGRRRGGRRGRR
public class XC1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String res = buildingHouse(s);
        String a="GGRGGRRGGGRRGRRRGGRGGRRRGGRRGRR";
        StringBuffer b=new StringBuffer();
        for(int i=0;i<a.length();i++){
            b.append(a.charAt(i));
        }
        System.out.println(res);
        System.out.println(a);
        System.out.println(b.toString().equals(a));
        System.out.println(res);
        System.out.println(Arrays.toString(a.getBytes()));
        System.out.println(Arrays.toString(res.getBytes()));
        System.out.println(Arrays.toString(b.toString().getBytes()));


    }



      public static String buildingHouse(String s) {
              for (int i = 0; i < s.length(); i++) {
                 if (!Character.isDigit(s.charAt(i))) {
                      return "N";
                 }
              }
              int n = Integer.parseInt(s);
              if (n < 1 || n > 12) {
                  return "O";
              }
              TR root = new TR('R', n);
              return TR.inorder(root);
          }

}

class TR {
    char val;
    TR left;
    TR right;

    public TR(char c, int height) {
        if (height < 1) {
            return;
        }
        this.val = c;
        int l = height;
        int r = height;
        this.left = new TR('G', height - 1);
        this.right = new TR('R', height - 1);


    }

    public static String inorder(TR root) {
        StringBuffer sb = new StringBuffer();
        mid(root, sb);
        return sb.toString();
    }

    public static void mid(TR root, StringBuffer sb) {
        if (root == null) {
            return;
        }
        mid(root.left, sb);
        sb.append(root.val);
        mid(root.right, sb);
    }
}


