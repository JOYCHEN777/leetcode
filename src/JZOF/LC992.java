package JZOF;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class LC992 {
    /*
    * 给定一个正整数数组 A，如果 A的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
（例如，[1,2,3,1,2] 中有3个不同的整数：1，2，以及3。）
返回A中好子数组的数目。
*/
    public static int subarraysWithKDistinct(int[] A, int K) {
        int res = 0;
        int[] mark = new int[A.length + 1];
        Set<Integer> num = new HashSet<>();
        for (int i = 1; i < A.length + 1; i++) {
            num.add(A[i - 1]);
            mark[i] = num.size();
        }
        int max = mark[mark.length - 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < A.length + 1; i++) {
            if (map.containsKey(mark[i])) {
                int v = map.get(mark[i]) + 1;
                map.replace(mark[i], v);
            } else {
                map.put(mark[i], 1);
            }
        }
        if (K == 1) {
            for(int i=1;i<=max;i++){
                int n=1;
                int k= map.get(i);
                while(k>0){
                    n*=k;
                    k--;
                }
                res+=n;
            }
        } else {
            for (int i = 0; i <= max - K + 1; i++) {
                int temp = 1;
                for (int j = 0; j <= K - 1; i++) {
                    temp *= map.get(i+j);
                }
                res += temp;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k));
    }
}
/* timeout
* int res = 0;
        for (int i = 0; i < A.length - K + 1; i++) {
            Set<Integer> s = new HashSet<>();
            s.add(A[i]);
            int j = i + 1;
            if(s.size()==K){
                res++;
            }
            while (s.size() <= K && j < A.length) {
                s.add(A[j]);
                if (s.size() > K) {
                    break;
                } else if (s.size() == K) {
                    res++;
                }
                j++;
            }
        }
        return res;*/
