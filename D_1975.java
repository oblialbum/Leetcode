package com.fengtin.LeetCode;

public class D_1975 {
    /**
     * 存在偶数个负数，则可以将其全部变为0；
     * 否则，可以将任意一个数变为负数。
     * @param matrix
     * @return
     */
    public long maxMatrixSum(int[][] matrix) {
        long res = 0;
        int cnt = 0,min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res += Math.abs(matrix[i][j]);
                if (matrix[i][j] < 0){
                    cnt++;
                }
                min = Math.min(min, Math.abs(matrix[i][j]));
            }
        }
        if (cnt % 2 == 0){
            return res;
        }
        return res - 2 * min;
    }
}
