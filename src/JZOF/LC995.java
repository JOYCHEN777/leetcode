package JZOF;

public class LC995 {
    /*在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组
    同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0。
返回所需的 K 位翻转的最小次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。
*/
    public static int minKBitFlips(int[] A, int K) {
        if (K == 1) {
            int sum = 0;
            for (int i = 0; i < A.length; i++) {
                sum += A[i];
            }
            return A.length - sum;
        }
        int[] mark = new int[A.length];
        int res = 0;
        for (int i = 0; i < A.length - K + 1; i++) {
            if (change(A, mark, i) != 1) {
                res++;
                mark[i] += 1;
                if (i + K < A.length) {
                    mark[i + K] -= 1;
                }

            }
            mark[i + 1] += mark[i];
        }
        for (int i = A.length - K + 2; i < A.length; i++) {
            mark[i] += mark[i - 1];
        }
        for (int i = A.length - K; i < A.length; i++) {
            if (change(A, mark, i) == 0) {
                return -1;
            }
        }
        return res;
    }

    public static int change(int[] num, int[] mark, int i) {
        if (mark[i] % 2 != 0) {
            return (num[i] == 1 ? 0 : 1);
        }
        return num[i];
    }
    public static void main(String[] args){
        int[] A=new int[]{0,0,0,1,0,1,1,0,1};
        int K=3;
        System.out.println(minKBitFlips(A,K));
    }

}
/* Timeout
public int minKBitFlips(int[] A, int K) {
        if (K == 1) {
            int sum = 0;
            for (int i = 0; i < A.length; i++) {
                sum += A[i];
            }
            return A.length - sum;
        }
        int index = 0;
        int res = 0;
        for (int i = 0; i < A.length - K + 1; i++) {
            if (A[i] == 1) {
                continue;
            } else {
                flip(A, K, i);
                res++;
            }
        }
        int judge=0;
        for(int i=A.length-K;i<A.length;i++){
            judge+=A[i];
        }
        if(judge==K){
            return res;
        }
        return -1;
    }

    public void flip(int[] num, int k, int first) {
        for (int i = first; i < first + k; i++) {
            num[i] = (num[i] == 1 ? 0 : 1);
        }
    }
* */
