package com.fengtin.LeetCode;

public class D_576 {
    /**
     * 球出界之后就不用再进行计算。
     * DP[i][j][k]:在（i,j）位置上，再走k步，有多少种出界路径。
     * @param m
     * @param n
     * @param maxMove
     * @param startRow
     * @param startColumn
     * @return
     */
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if(m == n && m == 1){
            return 4;
        }
        if(maxMove == 0){
            return 0;
        }
        int[][][] DP = new int[m][n][maxMove + 1];
        int mod = (int)(Math.pow(10,9)) + 7;
        /*
        * 初始化DP，在第一层时，四条边(出去四个角落)上的路径数为1，其他均为0。
        * */
        for(int i = 1;i < m - 1;i++){
            DP[i][0][1] += 1;
            DP[i][n - 1][1] += 1;
        }
        for(int i = 1;i < n - 1;i++){
            DP[0][i][1] += 1;
            DP[m - 1][i][1] +=  1;
        }
        if(m == 1){
            DP[0][0][1] = DP[0][n - 1][1] = 3;
        }
        else if(n == 1){
            DP[0][0][1] = DP[m - 1][0][1] = 3;
        }
        else{
            DP[0][n - 1][1] = DP[0][0][1] = 2;
            DP[m - 1][0][1] = DP[m - 1][n - 1][1] = 2;
        }
        if(m == n && m == 1){
            return 4;
        }
        for(int move = 2; move <= maxMove; move++){
            for(int i = 0;i < m;i++){
                for(int j = 0;j < n;j++){
                    if(i > 0){
                        DP[i][j][move] += DP[i - 1][j][move - 1];
                        DP[i][j][move] %= mod;
                    }
                    if(i < m - 1){
                        DP[i][j][move] += DP[i + 1][j][move - 1];
                        DP[i][j][move] %= mod;
                    }
                    if(j > 0){
                        DP[i][j][move] += DP[i][j - 1][move - 1];
                        DP[i][j][move] %= mod;
                    }
                    if(j < n - 1){
                        DP[i][j][move] += DP[i][j + 1][move - 1];
                        DP[i][j][move] %= mod;
                    }
                }
            }
        }
        int ans = 0;
        for(int i = 0;i <= maxMove;i++){
            ans += DP[startRow][startColumn][i];
            ans %= mod;
        }
        return ans;
    }
    public static void main(String[] args){
        new D_576().findPaths(10,10,0,5,5);
    }
}
