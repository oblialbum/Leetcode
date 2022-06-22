package com.fengtin.LeetCode;


import java.util.ArrayDeque;
import java.util.Queue;

public class D_934 {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (flag){
                break;
            }
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    dfs(grid,i,j,queue);
                    flag = true;
                    break;
                }
            }
        }
        int res = 0;
        int[] x = new int[]{1,-1,0,0};
        int[] y = new int[]{0,0,1,-1};
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int pos_x = pos[0];
                int pos_y = pos[1];
                for (int j = 0; j < 4; j++) {
                    int new_x = pos_x + x[j];
                    int new_y = pos_y + y[j];
                    if (judgeXy(grid,new_x,new_y)) {
                        if (grid[new_x][new_y] == 2) {
                            continue;
                        }
                        if (grid[new_x][new_y] == 1) {
                            return res;
                        }
                        queue.offer(new int[]{new_x, new_y});
                        grid[new_x][new_y] = 2;
                    }
                }
            }
            res++;
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j, Queue<int[]> queue) {
        if (!judgeXy(grid,i,j) || grid[i][j] == 2){
            return;
        }
        if(grid[i][j] == 0){
            queue.offer(new int[]{i,j});
            return;
        }
        grid[i][j] = 2;
        dfs(grid,i + 1,j,queue);
        dfs(grid,i - 1,j,queue);
        dfs(grid,i,j + 1,queue);
        dfs(grid,i,j - 1,queue);
    }

    private boolean judgeXy(int[][] grid, int i , int j){
        int n = grid.length;
        return i >= 0 && i < n && j >= 0 && j < n;
    }
}
