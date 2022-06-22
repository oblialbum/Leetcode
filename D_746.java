package com.fengtin.LeetCode;

public class D_746 {
    public int minCostClimbingStairs(int[] cost) {
        /**
         * dp[]记录抵达当前阶梯所需要的最小花费，dp[i] = math.min(dp[i - 1] +cost[i-1],dp[i - 2] +cost[i - 2])
         */
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2;i < cost.length;i++){
            dp[i] = Math.min(dp[i - 1] + cost[i],dp[i - 2] + cost[i]);
        }
        return Math.min(dp[dp.length - 1],dp[dp.length - 2]);
    }
}
