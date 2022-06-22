package com.fengtin.LeetCode;

public class D_1800 {
    public int maxAscendingSum(int[] nums) {
        int p = 1,res = nums[0],n = nums.length,sum = nums[0];
        while (p < n){
            if (nums[p] > nums[p - 1]){
                sum += nums[p];
            }else{
                sum = nums[p];
            }
            res = Math.max(res,sum);
            p++;
        }
        return res;
    }

    /**
     * 子序列
     * @param
     * @return
     */
//    public int maxAscendingSum(int[] nums) {
//        int n = nums.length,res = nums[0];
//        int[] dp = new int[n];
//        dp[0] = nums[0];
//        for (int i = 0; i < n; i++) {
//            dp[i] = nums[i];
//            for (int j = 0; j < i; j++) {
//                if (nums[i] > nums[j]){
//                    dp[i] = Math.max(dp[i],dp[j] + nums[i]);
//                }
//            }
//            res = Math.max(res,dp[i]);
//        }
//        return res;
//    }

    public static void main(String[] args) {
        new D_1800().maxAscendingSum(new int[]{10,20,30,5,10,50});
    }
}
