package com.fengtin.LeetCode;

public class D_1642 {
    public int countVowelStrings(int n) {
        /**
         a[i] = a[i - 1] + e[i - 1] + i[i - 1]+o[i - 1] + u[i - 1]?
         e[i] = e[i - 1] + i[i - 1]+o[i - 1] + u[i - 1]?
         i[i] = ei[i - 1]+o[i - 1] + u[i - 1]?
         o[i] = o[i - 1] + u[i - 1]?
         u[i] = u[i - 1]?
         */
        int[][] DP = new int[n+1][5];
        for(int i = 0;i < 5;i++){
            DP[1][i] = 1;
        }
        for(int i = 2;i <= n;i++){
            DP[i][0] = DP[i - 1][0] + DP[i - 1][1] + DP[i - 1][2] + DP[i - 1][3] + DP[i - 1][4];
            DP[i][1] = DP[i - 1][1] + DP[i - 1][2] + DP[i - 1][3] + DP[i - 1][4];
            DP[i][2] = DP[i - 1][2] + DP[i - 1][3] + DP[i - 1][4];
            DP[i][3] = DP[i - 1][3] + DP[i - 1][4];
            DP[i][4] = DP[i - 1][4];
        }
        return DP[n][0] + DP[n][1] + DP[n][2] + DP[n][3] +DP[n][4];
    }
}
