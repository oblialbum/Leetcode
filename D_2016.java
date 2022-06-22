package com.fengtin.LeetCode;

public class D_2016 {
    public int maximumDifference(int[] nums) {
        int res = -1,n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (nums[i]<nums[j]){
                    if (nums[j] - nums[i] > res){
                        res = nums[j] - nums[i];
                    }
                }
            }
        }
        return res;
    }
}
