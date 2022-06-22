package com.fengtin.LeetCode;

public class D_661 {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length,n = img[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = getAverage(img,i,j);
            }
        }
        return res;
    }

    private int getAverage(int[][] img, int x, int y) {
        int res = 0,nums = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int row = x + i,col = y + j;
                if (row < img.length && row >= 0 && col < img[0].length && col >=0){
                    res += img[row][col];
                    nums++;
                }
            }
        }
        return res/nums;
    }
}
