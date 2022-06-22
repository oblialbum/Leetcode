package com.fengtin.LeetCode;

public class D_283 {
    public void moveZeroes(int[] nums) {
        int occur = 0;
        for(int i = 0;i < nums.length   ;i++){
            if(nums[i] == 0){
                occur++;
                continue;
            }
            nums[i - occur] = nums[i];
        }
        for(int i = nums.length - 1;occur > 0;i--,occur--){
            nums[i] = 0;
        }
    }
}
