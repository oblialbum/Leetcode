package com.fengtin.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class D_1020 {
    boolean[][] visited;
    int[] x = new int[]{1,-1,0,0};
    int[] y = new int[]{0,0,1,-1};
    public int numEnclaves(int[][] grid) {
        int m = grid.length,n = grid[0].length,res = 0;
        Set<int[]> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1){
                        set.add(new int[]{i,j});
                    }
                    res++;
                }
            }
        }
        visited = new boolean[m][n];
        for (int[] border:set
             ) {
            dfs(grid,border[0],border[1]);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]){
                    res--;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int row, int col) {
        if (visited[row][col] || grid[row][col] != 1){
            return;
        }
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int newRow = row + x[i];
            int newCol = col + y[i];
            if (inBorder(grid,newRow,newCol)){
                dfs(grid,newRow,newCol);
            }
        }
    }

    private boolean inBorder(int[][] grid, int row, int col) {
        int m = grid.length,n = grid[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n){
            return false;
        }
        return true;
    }
}
