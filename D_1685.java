package com.fengtin.LeetCode;

public class D_1685 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n],ans = new int[n];
        prefixSum[0] = nums[0];
        for(int i = 1;i < n;i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        for(int i = 0;i < n;i++){
            if(i == 0){
                ans[0] = prefixSum[n - 1] - prefixSum[0] - (n - 1) * nums[0];
            }
            else if(i == n -  1){
                ans[n - 1] = (n - 1) * nums[n - 1] - prefixSum[n - 2];
            }
            else{
                ans[i] = i * nums[i] -(prefixSum[i - 1]) + prefixSum[n - 1] - prefixSum[i] - (n - i - 1) * nums[i];
            }

        }
        return ans;
    }
}
