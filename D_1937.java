package com.fengtin.LeetCode;

public class D_1937 {
    public long maxPoints(int[][] points) {
        int m = points.length,n = points[0].length;
        long[][] dp = new long[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = points[0][i];
        }
        for (int i = 1; i < m; i++) {
            long max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                max = Math.max(max,dp[i - 1][j] + j);
                dp[i][j] = Math.max(dp[i][j],max + points[i][j] - j);
            }
            max = Integer.MIN_VALUE;
            for (int j = n - 1; j >= 0 ; j--) {
                max = Math.max(max,dp[i - 1][j] - j);
                dp[i][j] = Math.max(dp[i][j], max + points[i][j] + j);
            }
        }
        long res = dp[m - 1][0];
        for (int i = 1; i < n; i++) {
            res = Math.max(res,dp[m - 1][i]);
        }
        return res;
    }
}
