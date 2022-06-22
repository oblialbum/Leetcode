package com.fengtin.LeetCode;

public class W_260 {
    public int maximumDifference(int[] nums) {
        int ans = -1;
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min) {
                ans = Math.max(ans, nums[i] - min);
            }
            min = Math.min(min, nums[i]);
        }
        return ans;
    }


    long ans = Integer.MAX_VALUE;
    long[][] dp;
    public long gridGame(int[][] grid) {
        dp = new long[2][grid[0].length];
        dp[0][0] = 0;
        traceBack(0, 0, grid);
        return ans;
    }

    private void traceBack(int row, int column, int[][] grid) {
        if (row == 1 && column == grid[0].length - 1) {
            dp[1][0] = dp[0][0] + grid[1][0];
            for(int i = 1;i < grid[0].length;i++){
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }
            for(int i = 1;i < grid[0].length;i++){
                dp[1][i] = Math.max(dp[0][i],dp[1][i - 1]) + grid[1][i];
            }
            ans = Math.min(ans,dp[1][grid[0].length - 1]);
            return;
        }
        if (row < 1) {
            int curNum = grid[row + 1][column];
            grid[row + 1][column] = 0;
            traceBack(row + 1, column,  grid);


            grid[row + 1][column] = curNum;
            if (column < grid[0].length - 1) {
                curNum = grid[row][column + 1];
                grid[row][column + 1] = 0;
                traceBack(row, column + 1,  grid);

                grid[row][column + 1] = curNum;
            }
        }
        else if (row == 1) {
            int curNum = grid[row][column + 1];
            grid[row][column + 1] = 0;
            traceBack(row, column + 1, grid);
            grid[row][column + 1] = curNum;
        }
    }
    public static void main(String[] args) {
        new W_260().gridGame(new int[][]{{20, 3, 20, 17, 2, 12, 15, 17, 4, 15}, {20, 10, 13, 14, 15, 5, 2, 3, 14, 3}});
        new W_260().gridGame(new int[][]{{3,3,1}, {8,5,2}});
    }
}
