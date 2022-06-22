package com.fengtin.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class D_329 {
    int[][] len ;
    int m,n;
    int[] x = new int[]{1,-1,0,0};
    int[] y = new int[]{0,0,1,-1};
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        len = new int[m][n];
        /**
         * 严格递增
         从记忆化搜索入手。
         dp[i][j]:i,j对应的最大递增长度。
         dp[i][j] = max(dp[i - 1][j],dp[i + 1][j],d[i][j - 1],dp[i][j + 1]) + 1.周围都比i,j大。
         找入度为0的点开始遍历。
         */
        /**
         * 找到入度为0的点。
         */
        Set<int[]> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean add = true;
                for (int k = 0; k < 4; k++) {
                    int newX = i + x[k];
                    int newY = j + y[k];
                    if (inArea(newX,newY)){
                        if (matrix[i][j] > matrix[newX][newY]){
                            add = false;
                            break;
                        }
                    }
                }
                if (add){
                    set.add(new int[]{i,j});
                }
            }
        }
        int max = 1;
        for (int[] begin:set
             ) {
            max = Math.max(max,dfs(matrix,begin[0],begin[1]));
        }
        return max;
    }

    private int dfs(int[][] matrix, int row, int col) {
        int max = 1;
        for (int i = 0; i < 4; i++) {
            int newRow = row + x[i];
            int newCol = col + y[i];
            if (!inArea(newRow,newCol)){
                continue;
            }
            if (matrix[row][col] < matrix[newRow][newCol]) {
                if (len[newRow][newCol] != 0) {
                    max = Math.max(max, len[newRow][newCol] + 1);
                } else {
                    max = Math.max(max, 1 + dfs(matrix, newRow, newCol));
                }
            }
        }
        len[row][col] = max;
        return max;
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
