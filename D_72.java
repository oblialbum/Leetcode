package com.fengtin.LeetCode;

public class D_72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if(n * m == 0){
            return m + n;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][ j - 1] + (word1.charAt(i) == word2.charAt(j) ? 0 : 1);
                dp[i][j] = Math.min(dp[i][j],Math.min(dp[i][ j - 1],dp[i - 1][j]) + 1);
            }
        }
        return dp[m][n];
    }
}
