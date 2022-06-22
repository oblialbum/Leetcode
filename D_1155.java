package com.fengtin.LeetCode;

public class D_1155 {

    public int numRollsToTarget(int n, int k, int target) {
        if (target < n || target > n * k){
            return 0;
        }
        int mod = (int) (1e9+7);
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 1; i <= Math.min(k,target); i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i + 1; j <= n * k; j++) {
                for (int l = 1; l <= k; l++) {
                    dp[i][j] += dp[i - 1][j - l] % mod;
                }

            }
        }
        return dp[n][target];
    }

    public static void main(String[] args) {
        new D_1155().numRollsToTarget(2,6,7);
    }
}
