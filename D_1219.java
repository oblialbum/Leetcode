package com.fengtin.LeetCode;

public class D_1219 {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] != 0){
                    ans = Math.max(dfs(grid,i,j),ans);
                }
            }
        }
        return ans;
    }
    private  int dfs(int[][] grid,int row,int column){

        int up = 0,down = 0,left = 0,right = 0,temp;
        temp = grid[row][column];
        if(canMove(row+1,column,grid)){
            grid[row][column] = 0;

            right = dfs(grid,row+1,column);
            grid[row][column] = temp;

        }
        if(canMove(row-1,column,grid)){
            grid[row][column] = 0;

            left = dfs(grid,row-1,column);
            grid[row][column] = temp;
        }
        if(canMove(row,column+1,grid)){
            grid[row][column] = 0;

            down = dfs(grid,row,column+1);
            grid[row][column] = temp;
        }
        if(canMove(row,column-1,grid)){
            grid[row][column] = 0;

            up = dfs(grid,row,column-1);
            grid[row][column] = temp;
        }
        if(!canMove(row+1,column,grid)){
            if(!canMove(row-1,column,grid)) {
                if (!canMove(row, column + 1, grid)) {
                    if(!canMove(row,column-1,grid)){
                        return temp;
                    }
                }
            }
        }
        int max = Math.max(left,Math.max(right,Math.max(up,down)));
        return grid[row][column] + max;
    }

    /**
     * 判断是否可以移动到该位置。
     * @param row
     * @param column
     * @param grid
     * @return
     */
    private boolean canMove(int row,int column,int[][] grid){
        if(row < grid.length && row >= 0){
            if(column < grid[0].length && column >= 0) {
                    return grid[row][column] != 0;
            }
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(new D_1219().getMaximumGold(new int[][]{{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}}));
    }
}
