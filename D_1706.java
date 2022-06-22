package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_1706 {
    int[] res;
    public int[] findBall(int[][] grid) {
        res = new int[grid[0].length];
        Arrays.fill(res,-1);
        for (int i = 0; i < grid[0].length; i++) {
            if (toNext(grid,0,i)){
                res[i] =  dfs(grid,1,i + grid[0][i]);
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row == grid.length){
            return col;
        }
        if (toNext(grid,row,col)){
            return dfs(grid,row+1,col + grid[row][col]);

        }
        return -1;
    }

    private boolean toNext(int[][] grid,int row,int col){
        if (grid[row][col] == 1){
            if (col == grid[0].length - 1){
                return false;
            }
            else{
                return grid[row][col + 1] == 1;
            }
        }else{
            if (col == 0){
                return false;
            }
            else{
                return grid[row][col - 1] == -1;
            }
        }
    }

    public static void main(String[] args) {
        new D_1706().findBall(new int[][]{{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}});
    }
}
