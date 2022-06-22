package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D_368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int maxSize = 1,maxVal = nums[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            if (dp[i] > maxSize){
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = n - 1; i >= 0 ; i--) {
            if (dp[i] == maxSize && maxVal % nums[i] == 0){
                list.add(nums[i]);
                maxVal = nums[i];
                maxSize--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        new D_368().largestDivisibleSubset(new int[]{4,8,3,16});
    }
}
