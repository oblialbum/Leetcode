package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_1034 {
    List<int[]> list = new ArrayList<>();
    int originalColor;
    int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    boolean[][] visited ;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        originalColor = grid[row][col];
        visited = new boolean[grid.length][grid[0].length];
        dfs(grid,row,col);
        for (int[] change:list
             ) {
            grid[change[0]][change[1]] = color;
        }
        return grid;
    }

    private void dfs(int[][] grid, int row, int col) {
        if(visited[row][col]){
            return;
        }
        visited[row][col] = true;
        boolean isborder = false;
        for (int[] dir:directions
             ) {
            int x = row + dir[0],y = col + dir[1];
            if((x >=0 && y >= 0 && x < grid.length && y < grid[0].length) && grid[x][y] == originalColor){
                dfs(grid,x,y);
            }
            else{
                isborder = true;
            }
        }
        if(isborder){
            list.add(new int[]{row,col});
        }
    }
}
