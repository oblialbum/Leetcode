package com.fengtin.LeetCode;

public class D_213 {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(robRange(nums,0,nums.length - 2),robRange(nums,1,nums.length - 1));
    }

    private int robRange(int[] nums, int start, int end) {
        int[][] dp = new int[nums.length - 1][2];
        dp[0][1] = nums[start];
        dp[0][0] = 0;
        for(int i = start + 1; i <= end;i++){
            dp[i - start][0] = Math.max(dp[i - start - 1][0],dp[i - start - 1][1]);
            dp[i - start][1] = dp[i - start - 1][0] + nums[i];
        }
        return Math.max(dp[end - start][0],dp[end - start][1]);
    }

    public static void main(String[] args){
        int[] nums = new int[]{2,3,2};
        new D_213().rob(nums);
    }
}
