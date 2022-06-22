package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_518 {
    public int change(int amount, int[] coins) {
        int[] DP = new int[amount + 1];
        DP[0] = 1;
        Arrays.sort(coins);
        if(coins[0] > amount){
            return 0;
        }
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                DP[i] += DP[i - coin];
            }
        }
        return DP[amount];
    }

    public static void main(String[] args){
        new D_518().change(5,new int[]{1,2,5});
    }
}
