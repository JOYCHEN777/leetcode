package BS;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class ALBB {
    public static void main(String[] args) {
        /*double[] res = redPakage(50, 6);
        double sum = 0;
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
            sum += res[i];
        }
        System.out.println(sum);*/
        int[] arr=new int[]{8,9,14,17,1,2,3,6,7};
        System.out.println(find(arr,1));

    }

    public static int find(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            }
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            if(nums[l]==target){
                return l;
            }
            if(nums[r]==target){
                return r;
            }
            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else if (nums[mid] < nums[l]) {
                r = mid;
            } else {
                r--;
            }
        }
        int minIndex = l;
        int maxIndex = l - 1 >= 0 ? l - 1 : nums.length - 1;
        if (target > nums[maxIndex] || target < nums[minIndex]) {
            return -1;
        }
        if (target < nums[nums.length - 1]) {
            return binarySearch(nums, minIndex, nums.length - 1, target);
        }
        return binarySearch(nums, 0, maxIndex, target);


    }

    public static int binarySearch(int[] arr, int l, int r, int n) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= n) {
                r = mid ;
            } else {
                l = mid+1;
            }
        }
        if(arr[l]==n){
            return l;
        }
        return -1;
    }

    public static double[] redPakage(double total, int n) {
        double[] res = new double[n];
        if (total < n || n < 4) {
            return res;
        }
        double max = 0.3 * total;
        double sum = 0;
        for (int i = 0; i < n - 1; i++) {

            //max = Math.max(0.3 * total, total-sum-(n-i));
            double unit = 1 + Math.random() * (max - 1);
            if (total - sum - unit >= n - i - 1) {
                res[i] = unit;
                sum += unit;
            } else {
                i--;
            }
        }
        if (total - sum <= 0.3 * total) {
            res[n - 1] = total - sum;
        } else {
            res[n - 1] = 0.3 * total;
            sum += res[n - 1];//sum里漏加了一个res[n-1]
            double dif = total - sum - res[n - 1];
            int time = 0;
            while (total - sum > 0.0001 && time < 20) {//加了一个循环,控制精度和数量防止时间太长
                for (int i = 0; i < n; i++) {
                    if (res[i] < 0.3 * total) {
                        if (Math.random() < 0.25) {//修改了此处防止每次加在第一个的概率过大
                            sum -= res[i];
                            res[i] = Math.max(res[i] + Math.random() * dif, 0.3 * total);
                            sum += res[i];
                            if (sum - total >= 0.0001) {
                                res[i] -= (sum - total);
                                return res;
                            }
                        }

                    }
                }
                time++;
            }

        }
        return res;
    }
}