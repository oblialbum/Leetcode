package com.fengtin.LeetCode;

public class D_1646 {
    public int getMaximumGenerated(int n) {
        /**
         分奇偶就行。
         */
        int[] dp = new int[n + 1];
        dp[0] = 0;
        if(n == 0){
            return dp[n];
        }
        dp[1] = 1;
        int max = dp[1];
        for(int i = 2;i <= n;i++){
            if(i % 2 == 0){
                dp[i] = dp[i / 2];
                max = Math.max(dp[i],max);
                continue;
            }
            dp[i] = dp[i / 2] + dp[i / 2 + 1];
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
