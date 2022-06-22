package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_1981 {
    int res = Integer.MAX_VALUE;
    boolean[][] visited = new boolean[80][5000];
    public int minimizeTheDifference(int[][] mat, int target) {
        for (int[] m:mat
        ) {
            Arrays.sort(m);
        }
        dfs(mat,target,0,0);
        return res;
    }

    private void dfs(int[][] mat, int target, int row, int sum) {
        if(sum - target > res || visited[row][sum]){
            return;
        }
        visited[row][sum] = true;
        if(row == mat.length){
            res = Math.min(Math.abs(target - sum),res);
            return;
        }
        for (int i = 0; i < mat[row].length; i++) {
            dfs(mat,target,row + 1,sum + mat[row][i]);
        }
    }
}
