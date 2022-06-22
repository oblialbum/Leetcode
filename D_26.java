package com.fengtin.LeetCode;

public class D_26 {
    /**
     * 有序数组，快慢指针。
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return nums.length;
        }
        int slow = 0,fast = 1;
        for(;fast < nums.length;fast++){
            if(nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return  slow+1;
    }
}
