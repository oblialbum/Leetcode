package com.fengtin.LeetCode;

public class D_264 {
    public int nthUglyNumber(int n) {
        /**
         * dp[n]:第n个丑数。
         * 每一个丑数均是由之前的丑数乘2，3，5得到的最小数。
         * 由p2,p3,p5表示当前需要乘以对应质数的丑数。
         */
        int [] dp = new int[n+1];
        dp[1] = 1;
        int p2 = 1,p3 = 1,p5 = 1;
        for(int i = 2;i <= n;i++){
            int num2 = dp[p2] * 2,num3 = dp[p3] * 3,num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2,num3),num5);
            if(dp[i] == num2){
                p2++;
            }
            if(dp[i] == num3){
                p3++;
            }
            if(dp[i] == num5){
                p5++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        new D_264().nthUglyNumber(10);
    }
}
