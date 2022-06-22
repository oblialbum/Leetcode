package com.fengtin.LeetCode;

public class D_53 {

    public int maxSubArray(int[] nums) {
        return dp(nums);
    }



    /**
     * DP求解，求当前位置为终点的最大连续子数组之和。
     * @param nums
     * @return
     */
    private int dp(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1;i < nums.length;i++){
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
        }
        return dp[dp.length - 1];
    }
}
