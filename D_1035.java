package com.fengtin.LeetCode;

public class D_1035 {
    /**
     * 最长公共子序列。
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] DP = new int[m + 1][n + 1];
        for(int i = 1;i <= m;i++){
            for(int j = 1;j <= n;j++){
                if(nums1[i - 1] == nums2[j - 1]){
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                }
                else{
                    DP[i][j] = Math.max(DP[i - 1][j],DP[i][j - 1]);
                }
            }
        }
        return DP[m][n];
    }
}
