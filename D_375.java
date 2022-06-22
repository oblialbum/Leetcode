package com.fengtin.LeetCode;

public class D_375 {
    public int getMoneyAmount(int n) {
        int[][] DP = new int[n+1][n+1];
        for(int i = n-1;i >=1;i--){
            for(int j = i + 1;j <= n;j++){
                int minCost = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = k + Math.max(DP[i][k - 1],DP[k + 1][j]);
                    minCost = Math.min(cost,minCost);
                }
                DP[i][j] = minCost;
            }
        }
        return DP[1][n];
    }
}
