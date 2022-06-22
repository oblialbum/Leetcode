package com.fengtin.LeetCode;

public class D_837 {
    public double new21Game(int n, int k, int maxPts) {
        if(n > (k - 1) + maxPts){
            return 1;
        }
        int w = maxPts,begin = 0,end = -1;
        double sum = 0;
        double[] DP = new double[n + 1];
        DP[0] = 1;
        for (int i = 1; i <= k ; i++) {
            /**
             * dp[i] = 前w个数的概率之和 /W.
             */
            end++;
            sum += DP[end];
            if(i <= w){
                DP[i] = sum / w;
            }
            else{
                sum -= DP[begin++];
                DP[i] = sum / w;
            }
        }
        double ans = 0;
        begin = Math.max(0,k - w);
        for (int i = k + 1; i <= n ; i++) {
            sum -= DP[begin];
            DP[i] = sum / w;
            ans += DP[i];
        }
        return ans;
    }

    public static void main(String[] args){
        new D_837().new21Game(6,1,10);
    }
}
