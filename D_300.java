package com.fengtin.LeetCode;

public class D_300 {
    /**
     * DP[i]:以i为结尾的最长递增子序列长度。
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] DP = new int[nums.length];
        DP[0] = 1;
        for(int i = 1;i < nums.length;i++){
            DP[i] = 1;
            for(int j = 0;j < i;j++){
                if(nums[j] < nums[i]){
                    DP[i] = Math.max(DP[i],DP[j] + 1);
                }
            }
        }
        int max = DP[0];
        for (int num: DP
             ) {
            max = Math.max(max,num);
        }
        return max;
    }
}
