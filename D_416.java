package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_416 {
    public boolean canPartition(int[] nums) {
        int sum = 0,n = nums.length;
        for (int num:nums
             ) {
            sum += num;
        }
        if(sum % 2 == 1){
            return false;
        }
        Arrays.sort(nums);
        if(nums[n - 1] > sum / 2){
            return false;
        }
        boolean[][] dp = new boolean[n][sum / 2 + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < sum / 2 + 1; j++) {
                if (j >= nums[i]){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
                else {
                    dp[i][j] = dp[i  - 1][j];
                }
            }
        }
        return dp[n - 1][sum / 2];
    }

    public static void main(String[] args) {
        new D_416().canPartition(new int[]{4,4,4,4,4,4,4,4,8,8,8,8,8,8,8,8,12,12,12,12,12,12,12,12,16,16,16,16,16,16,16,16,20,20,20,20,20,20,20,20,24,24,24,24,24,24,24,24,28,28,28,28,28,28,28,28,32,32,32,32,32,32,32,32,36,36,36,36,36,36,36,36,40,40,40,40,40,40,40,40,44,44,44,44,44,44,44,44,48,48,48,48,48,48,48,48,52,52,52,52,52,52,52,52,56,56,56,56,56,56,56,56,60,60,60,60,60,60,60,60,64,64,64,64,64,64,64,64,68,68,68,68,68,68,68,68,72,72,72,72,72,72,72,72,76,76,76,76,76,76,76,76,80,80,80,80,80,80,80,80,84,84,84,84,84,84,84,84,88,88,88,88,88,88,88,88,92,92,92,92,92,92,92,92,96,96,96,96,96,96,96,96,97,99});
    }
}
