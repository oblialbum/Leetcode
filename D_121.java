package com.fengtin.LeetCode;

public class D_121 {
    public int maxProfit(int[] prices) {
        if(prices.length == 1){
            return  0;
        }
        /**
         * dp:记录当前日期前的最低价格,当前日期的最大profit = 当前价格 - 最低价格。。
         */
        int max = 0;
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        for(int i = 0 ;i < prices.length;i++){
            dp[i] = Math.min(dp[i-1],prices[i]);
            max = Math.max(prices[i] - dp[i],max);
        }
        return  max;
        /*
        找到一个数和它右边数的最大差值，从右向做遍历，维护最大售出价格，最大利润。
        int maxSellPrice = prices[prices.length - 1];
        int maxProfit = 0;
        for(int i = prices.length - 2;i >= 0;i--){
            maxProfit = Math.max(maxProfit,maxSellPrice - prices[i]);
            maxSellPrice = Math.max(maxSellPrice,prices[i]);
        }
        return maxProfit;
         */
    }
}
