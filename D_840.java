package com.fengtin.LeetCode;

public class D_840 {
    public int numMagicSquaresInside(int[][] grid) {
        if(grid.length  < 3 || grid[0].length < 3){
            return 0;
        }
        int n = grid.length;
        int ans = 0;
        for(int i = 0; i < n- 2;i++){
            for(int j = 0;j < n - 2;j++){
                ans += judgeMagicSquare(grid,i,j);
            }
        }
        return ans;
    }

    private int judgeMagicSquare(int[][] grid, int row, int col) {
        if(grid[row + 1][col + 1] != 5){
            return 0;
        }
        int[] occur = new int[16];
        int sum = 0;
        for(int i = row;i <= row + 2;i++){
            for(int j = col;j <= col + 2;j++){
                occur[grid[i][j]]++;
                sum += grid[i][j];
            }
        }
        if(sum != 45){
            return 0;
        }
        for(int i = 1;i < 10;i++){
            if(occur[i] != 1){
                return 0;
            }
        }
        if(
                grid[row][col] + grid[row + 1][col] + grid[row  + 2][col] == 15 &&
                        grid[row][col + 1] + grid[row + 1][col + 1] + grid[row  + 2][col + 1] == 15 &&
                        grid[row][col + 2] + grid[row + 1][col + 2] + grid[row  + 2][col + 2] == 15 &&
                        grid[row][col] + grid[row + 1][col + 1] + grid[row  + 2][col + 2]==15 &&
                        grid[row][col + 2] + grid[row + 2][col] + grid[row  + 1][col + 1]==15 &&
                        grid[row][col] + grid[row][col + 1] + grid[row][col + 2] == 15 &&
                        grid[row + 1][col] + grid[row + 1][col + 1] + grid[row + 1][col + 2] == 15 &&
                        grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2] == 15
        ) {
            return 1;
        }
        else{
            return 0;
        }
    }
}
