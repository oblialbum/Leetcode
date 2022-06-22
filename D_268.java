package com.fengtin.LeetCode;

public class D_268 {
    public int missingNumber(int[] nums) {
        int targetSum = nums.length * (nums.length + 1) / 2;
        for(int i = 0;i < nums.length;i++){
            targetSum -= nums[i];
        }
        return targetSum;
    }
}
