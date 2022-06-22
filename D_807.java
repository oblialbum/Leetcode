package com.fengtin.LeetCode;

public class D_807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int ans = 0,n = grid.length;
        int[] rows = new int[n],cols = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rows[i] = Math.max(rows[i],grid[i][j]);
                cols[j] = Math.max(cols[j],grid[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += Math.min(rows[i],cols[j]) - grid[i][j];
            }
        }
        return ans;
    }
}
