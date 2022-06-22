package com.fengtin.LeetCode;

public class D_647 {
    public int countSubstrings(String s) {
        int n = s.length();
        int cnt = n;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                boolean b = s.charAt(i) == s.charAt(j);
                if(j == i + 1){
                    dp[i][j] = b;
                }
                else {
                    dp[i][j] = dp[i + 1][j - 1] && b;
                }
                if(dp[i][j]){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
