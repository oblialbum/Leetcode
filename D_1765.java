package com.fengtin.LeetCode;

import java.util.ArrayDeque;
import java.util.Queue;

public class D_1765 {
    int[] nextRow = new int[]{1,-1,0,0};
    int[] nextCol = new int[]{0,0,1,-1};
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length,n = isWater[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] res = new int[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1){
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int row = cur[0],col = cur[1];
                addNeighbor(queue,row,col,res,visited);
            }
        }
        return res;
    }

    private void addNeighbor(Queue<int[]> queue, int row, int col, int[][] res, boolean[][] visited) {
        for (int i = 0; i < 4; i++) {
            int neighborRow = row + nextRow[i],neighborCol = col + nextCol[i];
            if (neighborRow < 0 || neighborRow >= res.length || neighborCol < 0 || neighborCol >= res[0].length){
                continue;
            }
            if (visited[neighborRow][neighborCol]){
                continue;
            }
            visited[neighborRow][neighborCol] = true;
            res[neighborRow][neighborCol] = res[row][col] + 1;
            queue.offer(new int[]{neighborRow,neighborCol});
        }
    }

    public static void main(String[] args) {
        new D_1765().highestPeak(new int[][]{{0,0,1},{1,0,0},{0,0,0}});
    }
}
