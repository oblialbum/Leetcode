package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_122 {
    /**
     * DP[i][0]:第i天结束后 不持有 股票的最大收益。
     * dp[i][1]:第i天结束后 持有 股票的最大收益。
     * @param prices
     * @return
     */
    int maxProfit = 0;
    int[][] tempProfit;
    public int maxProfit(int[] prices) {
        tempProfit = new int[prices.length][2];
        for(int i = 0;i < prices.length;i++){
            Arrays.fill(tempProfit[i],Integer.MIN_VALUE);
        }
        dfs(prices,0,0,0);
        return maxProfit;
    }

    private void dfs(int[] prices, int pos, int status, int profit) {
        if(pos == prices.length){
            maxProfit = Math.max(profit,maxProfit);
            return;
        }

        if(profit > tempProfit[pos][status]){
            tempProfit[pos][status] = profit;
        }
        else{
            return;
        }
        dfs(prices,pos+1,status,profit);

        if(status == 0){
            if(profit - prices[pos] > tempProfit[pos][1]){
                tempProfit[pos][1] = profit - prices[pos];
            }
            else{
                return;
            }
            dfs(prices,pos+1,1,profit - prices[pos]);
        }
        else{
            if(profit + prices[pos] > tempProfit[pos][0]){
                tempProfit[pos][0] = profit + prices[pos];
            }
            else{
                return;
            }
            dfs(prices,pos+1,0,profit + prices[pos]);
        }
    }

    public int DP(int[] prices){
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1;i < prices.length;i++){
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i],dp[i - 1][1]);
        }
        return dp[prices.length][0];
    }
}
