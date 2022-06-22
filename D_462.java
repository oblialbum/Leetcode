package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_462 {
    public int minMoves2(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        int ans = 0;
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        for (int num:nums
             ) {
            ans += Math.abs(num - mid);
        }
        return ans;
    }
}
