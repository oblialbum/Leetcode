package com.fengtin.LeetCode;

public class D_73 {
    /**
     * O(1)
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRow = false;
        boolean firstColumn = false;
        for(int i = 0;i < m;i++){
            if(matrix[i][0] == 0){
                firstColumn = true;
                break;
            }
        }
        for(int i = 0;i < n;i++){
            if(matrix[0][i] == 0){
                firstRow = true;
            }
        }
        for(int i = 1;i < m;i++){
            for (int j = 1;j < n;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1;i < m;i++){
            for (int j = 1;j < n;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(firstRow){
            for(int i = 0;i < n;i++){
                matrix[0][i] = 0;
            }
        }
        if(firstColumn){
            for(int i = 0;i < n;i++){
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new D_73().setZeroes(matrix);
    }
}
