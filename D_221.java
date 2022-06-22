package com.fengtin.LeetCode;

public class D_221 {
    /**
     * DP表示以(i,j)为右下角顶点的正方形的最大边长。初始化为matrix[i][j]的值。
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0] == '1'? 1 : 0;
        int maxSide = dp[0][0];
        for(int i = 1;i < matrix.length;i++){
            if(matrix[i][0] == '1'){
                dp[i][0] = 1;
            }
            maxSide = Math.max(maxSide,dp[i][0]);
        }
        for(int i = 1;i < matrix[0].length;i++){
            if(matrix[0][i - 1] == '1'){
                dp[0][i] = 1;
            }
            maxSide = Math.max(maxSide,dp[0][i]);
        }
        for(int i = 1;i <matrix.length;i++){
            for(int j = 1;j < matrix[i].length;j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

       return maxSide * maxSide;
    }

    /**
     * 方法以：暴力解决，效果不错。
     * @param matrix
     * @return
     */
    private int baoli(char[][] matrix) {
        int maxSide = 0;
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[i].length;j++){
                if(matrix[i][j] == '0'){
                    continue;
                }
                maxSide = Math.max(maxSide,1);
                if(i + maxSide >= matrix.length ||j + maxSide >= matrix[i].length){
                    continue;
                }
                maxSide = getMaxSide(matrix,i,j,maxSide);
            }
        }
        return maxSide * maxSide;
    }

    private int getMaxSide(char[][] matrix, int row, int column, int curSide) {
        /**
         * 先验证以i,j为顶点的，边长为curSide的正方形是否满足。
         */
        int rows = row + curSide;
        int columns = column + curSide;
        for(int i = row;i < rows;i++){
            for(int j = column;j < columns;j++){
                if(matrix[i][j] == '0'){
                    return  curSide;
                }
            }
        }
        /**
         * 依次验证最下面一行，最右边一行是否满足要求。
         */
        while(rows < matrix.length && columns < matrix[0].length){
            for(int i = column;i <= columns;i++){
                if(matrix[rows][i] == '0'){
                    return  curSide;
                }
            }
            for(int i = row;i <= rows;i++){
                if(matrix[i][columns] == '0'){
                    return  curSide;
                }
            }
            rows++;
            columns++;
            curSide++;
        }
        return curSide;
    }

    public static void main(String[] args){
        String[][] temp = new String [][]{{"0","0","0","0","1","1","1","0","1"},{"0","0","1","1","1","1","1","0","1"},{"0","0","0","1","1","1","1","1","0"}};
        char[][] matrix = new char[temp.length][temp[0].length];
        for(int i = 0;i < temp.length;i++){
            for(int j = 0;j < temp[i].length;j++) {
                matrix[i][j] = temp[i][j].charAt(0);
            }
        }
        new D_221().maximalSquare(matrix);
    }
}
