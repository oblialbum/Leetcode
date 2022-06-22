package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_54 {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int loop = 0;
        while(loop * 2 < Math.min(m,n)){
            iterate(matrix,loop);
            loop++;
        }
        return  ans;
    }

    private void iterate(int[][] matrix, int loop) {
        int width = matrix.length - 2 * loop;
        int length =  matrix[0].length - 2 * loop;
        for(int i = loop;i < matrix[0].length - loop;i++){
            ans.add(matrix[loop][i]);
        }
        if(width == 1){
            return;
        }
        /**
         * 不要重复添加元素。
         */
        for(int i = loop + 1; i < matrix.length - loop;i++){
            ans.add(matrix[i][matrix[0].length - loop - 1]);
        }
        if(length == 1){
            return;
        }
        for(int i = matrix[0].length - loop - 2;i >= loop ;i --){
            ans.add(matrix[matrix.length - loop - 1][i]);
        }
        for(int i = matrix.length - loop - 2;i  > loop;i--){
            ans.add(matrix[i][loop]);
        }
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{{1},{2},{3}};
        new D_54().spiralOrder(matrix);
    }
}
