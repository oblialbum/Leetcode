package com.fengtin.LeetCode;

public class D_200 {
    public int numIslands(char[][] grid) {
        int answer = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == '1'){
                    dfs(grid,i,j);
                    answer++;
                }
            }
        }
        return answer;
    }
    private void dfs(char[][] grid ,int row,int column){
        if(row < 0 || row >= grid.length || column < 0 || column >= grid[row].length || grid[row][column] != '1'){
            return;
        }
        grid[row][column] = '#';
        dfs(grid,row + 1,column);
        dfs(grid,row - 1,column);
        dfs(grid,row,column + 1);
        dfs(grid,row,column - 1);
    }
}
