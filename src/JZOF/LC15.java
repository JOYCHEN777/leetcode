package JZOF;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {
    /*给你一个包含 n 个整数的数组nums，
    判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？
    请你找出所有和为 0 且不重复的三元组。
    注意：答案中不可以包含重复的三元组。
*/
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i<nums.length-1&&nums[i]+nums[i+1]>0){
                return res;
            }
            if(i>=1&&nums[i]==nums[i-1]){
                continue;
            }
            int two = -nums[i];
            int l = i + 1;
            int r = nums.length-1;
            while (l < r) {
                if (nums[l] + nums[r] > two) {
                    r--;
                }else if(nums[l]+nums[r]<two){
                    l++;
                }else{
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l<r&&nums[l]==nums[l+1]){
                        l++;
                    }
                    while(l<r&&nums[r]==nums[r-1]){
                        r--;
                    }
                    l++;
                    r--;
                }
            }
        }
        return res;
    }
}
