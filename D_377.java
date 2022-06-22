package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_377 {
    public int combinationSum4(int[] nums, int target) {
        int[] DP = new int[target + 1];
        Arrays.sort(nums);
        if(nums[0] > target){
            return 0;
        }
        DP[0] = 1;
        for (int i = 1; i <= target ; i++) {
            for (int j = 0; j <nums.length ; j++) {
                if(nums[j] <= i){
                    DP[i] += DP[i - nums[j]];
                }
                else{
                    break;
                }
            }
        }
        return DP[target];
    }

    public static void main(String[] args) {
        new D_377().combinationSum4(new int[]{1,2,3},4);
    }

}
