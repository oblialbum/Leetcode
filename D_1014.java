package com.fengtin.LeetCode;

public class D_1014 {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length,res = -10000;
        int[] dp = new int[n];
        dp[n - 1] = values[n - 1] - (n - 1);
        for (int i = n - 2; i >= 0 ; i--) {
            dp[i] = Math.max(dp[i + 1],values[i]-i);
        }
        for (int i = 0; i < n - 1; i++) {
            res = Math.max(values[i] + i + dp[i + 1],res);
        }
        return res;
    }
}
