package com.fengtin.LeetCode;

public class D_689 {
    /**
     * 只求出来了最大和，没有得到下标。
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] ans = new int[3];
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int[][] dp = new int[3][nums.length];
        dp[0][k - 1] = sum[k-1];
        dp[1][2 * k - 1] = sum[2 * k - 1];
        dp[2][3 * k - 1] = sum[3 * k - 1];
        for (int i = k; i < nums.length; i++) {
            dp[0][i] =Math.max(sum[i] - sum[i - k],dp[0][i - 1]);
        }
        for (int i = 2 * k; i < nums.length; i++) {
            dp[1][i] = Math.max(dp[1][i - 1],sum[i] - sum[i - k] + dp[0][i - k]);
        }
        for (int i = 3 * k; i < nums.length; i++) {
            dp[2][i] = Math.max(dp[2][i - 1],sum[i] - sum[i - k] + dp[1][i - k]);
        }
        return ans;
    }

    public static void main(String[] args) {
        new D_689().maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1},2);
    }
}
