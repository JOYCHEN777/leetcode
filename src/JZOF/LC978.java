package JZOF;

public class LC978 {
    /*当 A的子数组A[i], A[i+1], ..., A[j]满足下列条件时，我们称其为湍流子数组：
若i <= k < j，当 k为奇数时，A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
或 若i <= k < j，当 k 为偶数时，A[k] > A[k+1]，且当 k为奇数时，A[k] < A[k+1]。
也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
返回 A 的最大湍流子数组的长度。
*/
    public static int maxTurbulenceSize(int[] arr) {
        if (arr.length < 2) {
            return arr.length;
        }
        if (arr.length == 2) {
            if (arr[0] == arr[1]) {
                return 1;
            } else {
                return 2;
            }
        }
        int[] mark = new int[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] > arr[i]) {
                mark[i] = 1;
            } else if (arr[i + 1] < arr[i]) {
                mark[i] = 0;
            } else {
                mark[i] = 2;
            }
        }
        int res = 0;
        int temp = 0;
        for (int i = 0; i < mark.length; i++) {
            if(mark[i]==2){
                res=Math.max(res,temp);
            }else{
                temp+=1;
                while(i<mark.length-1){
                    if(mark[i+1]!=mark[i]&&mark[i+1]!=2){
                        temp++;
                        i++;
                    }else{
                        break;
                    }
                }
                res=Math.max(res,temp);
                temp=0;
            }
        }
        return res + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9,9,9,4,5};
        System.out.println(maxTurbulenceSize(nums));
    }
}
