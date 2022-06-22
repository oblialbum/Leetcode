package com.fengtin.LeetCode;

public class D_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[m - 1][n - 1]){
            return false;
        }
        int end = m - 1;
        while(matrix[end][0] > target){
            end--;
        }
        for(int i = 0;i <= end;i++){
            int left = 0,right = n - 1;
            if(matrix[i][right] < target){
                continue;
            }
            while(left <= right){
                int mid = left + (right - left ) / 2 ;
                if(matrix[i][mid] == target){
                    return true;
                }
                if(matrix[i][mid] > target){
                    right = mid - 1;
                }
                if(matrix[i][mid] < target){
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
