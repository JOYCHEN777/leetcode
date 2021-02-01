package JZOF;

public class LC724 {
    /*给你一个整数数组nums，请编写一个能够返回数组 “中心索引” 的方法。
数组 中心索引 是数组的一个索引，其左侧所有元素相加的和等于右侧所有元素相加的和。
如果数组不存在中心索引，返回 -1 。如果数组有多个中心索引，应该返回最靠近左边的那一个。
注意：中心索引可能出现在数组的两端。
*/
    public int pivotIndex(int[] nums) {

        int right=0;
        int left=0;
        for(int i=0;i<=nums.length-1;i++){
            right+=nums[i];
        }
        for(int i=0;i<=nums.length-1;i++){
            right-=nums[i];
            if(right==left){
                return i;
            }else{
                left+=nums[i];
            }
        }
        return -1;
    }
}
