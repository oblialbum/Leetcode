package com.fengtin.LeetCode;

public class D_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[m - 1][n - 1]){
            return false;
        }
        int row = -1;
        int left = 0,right = m - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(matrix[mid][n - 1] > target){
                right = mid - 1;
            }
            if(matrix[mid][n - 1] == target){
                return true;
            }
            if(matrix[mid][n - 1] < target){
                left = mid + 1;
            }
        }
        row = left;
        left = 0;
        right = n - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(matrix[row][mid] > target){
                right = mid - 1;
            }
            if(matrix[row][mid] == target){
                return true;
            }
            if(matrix[row][mid] < target){
                left = mid + 1;
            }
        }
        return false;
    }
}
