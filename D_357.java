package com.fengtin.LeetCode;

public class D_357 {
    static int[] dp;
    static{
        dp = new int[10];
        dp[0] = 1;
        dp[1] = 9;
        for (int i = 2; i < 10; i++) {
            dp[i] = dp[i - 1] * (11 - i);
        }
    }
    public int countNumbersWithUniqueDigits(int n) {
        int res = 0;
        for (int i = 0; i <= n; i++) {
            res += dp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        new D_357().countNumbersWithUniqueDigits(2);
    }
}
