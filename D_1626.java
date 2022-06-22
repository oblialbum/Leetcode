package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_1626 {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }
        Arrays.sort(arr,(x,y) ->(x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]));
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i][1];
        }
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0 ; j--) {
                if (arr[j][1] <= arr[i][1]){
                    dp[i] = Math.max(dp[j] + arr[i][1],dp[i]);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

}
