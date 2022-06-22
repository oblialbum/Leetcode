package com.fengtin.LeetCode;

public class D_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        for (int i = 1; i <= len ; i++) {
            int[] zeroOnes = caculate(strs[i - 1]);
            int zero = zeroOnes[0],one = zeroOnes[1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if(j >= zero && k >= one){
                        dp[i][j][k] = Math.max(dp[i][j][k],dp[i - 1][j - zero][k - one] + 1);
                    }
                }
            }
        }
        return dp[len][m][n];
    }

    private int[] caculate(String str) {
        int zero = 0,one = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '0'){
                zero++;
            }
            else{
                one++;
            }
        }
        return new int[]{zero,one};
    }
}
