package com.fengtin.LeetCode;

public class D_931 {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int[][] DP = new int[matrix.length][matrix.length];
        for(int i = 0;i < matrix.length;i++){
            DP[0][i] = matrix[0][i];
        }
        for(int i = 1;i < matrix.length;i++){
            for(int j = 0;j < matrix.length;j++){
                if(j == 0){
                    DP[i][j] =Math.min( DP[i - 1][j],DP[i - 1][j + 1]) + matrix[i][j];
                }
                else if(j == matrix.length - 1){
                    DP[i][j] = Math.min(DP[i - 1][j],DP[i - 1][ j - 1]) + matrix[i][j];
                }
                else{
                    DP[i][j] = Math.min(Math.min(DP[i - 1][j],DP[i - 1][ j - 1]),DP[i - 1][j + 1]) + matrix[i][j];
                }
            }
        }
        for(int i = matrix.length - 1;i >= 0;i--){
            min = Math.min(min,DP[matrix.length][i]);
        }
        return min;
    }
}
