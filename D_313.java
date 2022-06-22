package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1){
            return 1;
        }
        int[] dp = new int[n + 1],p = new int[primes.length];
        dp[1] = 1;
        Arrays.fill(p,1);
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                int temp = primes[j] * dp[p[j]];
                if (temp > dp[i - 1] && temp < dp[i]){
                    dp[i] = temp;
                }
            }
            for (int j = 0; j < primes.length; j++) {
                if (dp[i] == primes[j] * dp[p[j]]){
                    p[j]++;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        new D_313().nthSuperUglyNumber(15,new int[]{3,5,7,11,19,23,29,41,43,47});
    }
}
