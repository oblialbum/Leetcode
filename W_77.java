package com.fengtin.LeetCode;

import java.util.Arrays;

public class W_77 {
    public int countPrefixes(String[] words, String s) {
        int res = 0;
        for (String word: words
             ) {
            if (s.startsWith(word)){
                res++;
            }
        }
        return res;
    }

    public int minimumAverageDifference(int[] nums) {
        int idx = -1,target = Integer.MAX_VALUE,n = nums.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        int cur,suffix;
        for (int i = 0; i < n; i++) {
            if (i == n - 1){
                suffix = 0;
            }else{
                suffix = (int) ((prefixSum[n - 1] - prefixSum[i])/(n - i - 1));
            }
            cur = (int) Math.abs(prefixSum[i] / (i + 1) - suffix);
            if (cur < target){
                target = cur;
                idx = i;
            }
        }
        return idx;
    }
    int res;
    int[][] grid;

    /**
     * -1，0，1，2:未被观测，被观测，守卫，墙
     * @param m
     * @param n
     * @param guards
     * @param walls
     * @return
     */
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        grid = new int[m][n];
        for (int[] arr:grid
             ) {
            Arrays.fill(arr,-1);
        }
        for (int[] arr:guards
             ) {
            grid[arr[0]][arr[1]] = 1;
        }
        for (int[] arr:walls
             ) {
            grid[arr[0]][arr[1]] = 2;
        }
        for (int[] arr:guards
             ) {
            visit(m,n,arr[0],arr[1]);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1){
                    res++;
                }
            }
        }
        return res;
    }

    private void visit(int m, int n, int row, int col) {
        for (int i = row + 1; i < m; i++) {
            if (grid[i][col] == 0 || grid[i][col] == -1){
                grid[i][col] = 0;
            }else{
                break;
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            if (grid[i][col] == 0 || grid[i][col] == -1){
                grid[i][col] = 0;
            }else{
                break;
            }
        }

        for (int i = col + 1; i < n; i++) {
            if (grid[row][i] == 0 || grid[row][i] == -1){
                grid[row][i] = 0;
            }else{
                break;
            }
        }
        for (int i = col - 1; i >= 0; i--) {
            if (grid[row][i] == 0 || grid[row][i] == -1){
                grid[row][i] = 0;
            }else{
                break;
            }
        }
    }


    public static void main(String[] args) {

    }
}
