package com.fengtin.LeetCode;

public class D_650 {
    /**
     * n % 2 == 0,dp[n] = dp[n / 2] + 2;
     * n % 2 == 1,dp[n] = ?
     * @param n
     * @return
     */
    static int[] dp = new int[1001];
    static {
        dp[1] = 0;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i < dp.length; i++) {
            if (i % 2 == 0){
                dp[i] = dp[i / 2] + 2;
            }else {
                /**
                 * 判断是否为素数。
                 */
                int idx = getMinFactor(i);
                if (idx == 1){
                    dp[i] = i;
                }else{
                    dp[i] = dp[i / idx] + idx;
                }
            }
        }
    }

    private static int getMinFactor(int n) {
        for (int i = 2; i < Math.pow(n,0.5) + 1; i++) {
            if (n % i == 0){
                return i;
            }
        }
        return 1;
    }

    public int minSteps(int n) {
        return dp[n];
    }
}
