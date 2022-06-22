package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        Arrays.sort(coins);
        for (int i = 1; i < amount + 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin: coins
                 ) {
                if(i >= coin){
                    if(dp[i - coin] == -1){
                        continue;
                    }
                    min = Math.min(min,dp[i - coin] + 1);
                }
                else{
                    break;
                }
            }
            dp[i] = (min == Integer.MAX_VALUE ? -1:min);
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        new D_322().coinChange(new int[]{1,2,5},11);
    }
}
