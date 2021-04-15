package JZOF;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 */
public class LC73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        String s = new String("asdasdasd");
        char[] t1 = s.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int x : row) {
            for (int i = 0; i < n; i++) {
                matrix[x][i] = 0;
            }
        }
        for (int x : col) {
            for (int i = 0; i < m; i++) {
                matrix[i][x] = 0;
            }
        }
    }

    /**
     * @param sentence1
     * @param sentence2
     * @return
     */
    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] arr1 = sentence1.split(" ");
        String[] arr2 = sentence2.split(" ");
        return arr1.length > arr2.length ? f1(arr1, arr2) : f1(arr2, arr1);
    }

    public static boolean f1(String[] arr1, String[] arr2) {
        if (!arr2[0].equals(arr1[0])) {
            for (int i = 0; i < arr2.length; i++) {
                if (!arr2[arr2.length - 1 - i].equals(arr1[arr1.length - 1 - i])) {
                    return false;
                }
            }
        } else {
            int mark = arr2.length;
            for (int i = 0; i < arr2.length; i++) {
                if (!arr2[i].equals(arr1[i])) {
                    mark = i;
                    break;
                }
            }
            for (int i = 0; i < arr2.length - mark; i++) {
                if (!arr2[arr2.length - 1 - i].equals(arr1[arr1.length - 1 - i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int clumsy(int N) {
        if (N <= 2) {
            return N;
        }
        int res = 0;
        Stack<Integer> s = new Stack<>();
        int n = N;
        int sign = 1;
        while (n > 0) {
            int a = n * (n - 1);
            if(n==1){
                a=1;
            }
            n--;
            if (n >= 2) {
                a = a / (n - 1);
            }
            n--;
            s.push(sign * a);
            if (n >= 2) {
                s.push(n - 1);
            }
            n--;
            sign = -1;
            n--;
        }
        while (!s.isEmpty()) {
            res += s.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(clumsy(40));
    }
}
