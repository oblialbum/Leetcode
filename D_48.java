package com.fengtin.LeetCode;

public class D_48 {
    /**
     * 顺时针旋转90°。
     * 外围先旋转，再到内部，一直到最内部一个元素。
     * 矩阵长度N 为奇数时，剩下一个元素无需处理，为偶数时正好处理完。
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if ((n / 2) > 0) {
            // 每次旋转一环，loop为当前处理旋转的是第几环，从外往内数
            recursion(matrix, n, 0);
        }
    }

    // 处理当前环
    private void recursion(int[][] matrix, int n, int loop) {
        // 当前环的宽度
        int m = n - 2 * loop;
        if (loop  >= n / 2) {
            return;
        }
        for (int i = 0; i < (m - 1); i++) {
            int temp = matrix[loop][loop + i];
            matrix[loop][loop + i] = matrix[loop + m - 1 - i][loop];
            matrix[loop + m - 1 - i][loop] = matrix[loop + m - 1][loop + m - 1 - i];
            matrix[loop + m - 1][loop + m - 1 - i] = matrix[loop + i][loop + m - 1];
            matrix[loop + i][loop + m - 1] = temp;
        }
        recursion(matrix, n, loop + 1);
    }
    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        new D_48().rotate(matrix);
    }
}
