package com.fengtin.LeetCode;

public class D_42 {
    /**
     * 找到1 -（n-1）下标左右俩边比该高度高的最大高度的下标，取俩者的较小高度减去该小标高度，即为该下标可以接的雨水数量。
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int ans = 0,n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1],height[i]);
        }
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0 ; i--) {
            rightMax[i] = Math.max(rightMax[i + 1],height[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            ans += Math.max(Math.min(leftMax[i - 1],rightMax[i + 1]) - height[i], 0);
        }
        return ans;
    }
}
