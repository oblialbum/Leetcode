package com.fengtin.LeetCode;

public class D_1631 {
    int ans = Integer.MAX_VALUE;
    boolean[][] visited ;
    public int minimumEffortPath(int[][] heights) {
        visited = new boolean[heights.length][heights[0].length];
        DFS(heights,0,0,0,heights[0][0]);
        return ans;
    }

    private void DFS(int[][] heights, int row, int col, int diff,int pre) {
        if(row >= heights.length || col >= heights[0].length || row < 0 || col < 0){
            return;
        }
        if(visited[row][col]){
            return;
        }
        if(diff >= ans){
            return;
        }
        if(diff < Math.abs(heights[row][col] - pre)){
            diff = Math.abs(heights[row][col] - pre);
        }
        
        visited[row][col] = true;
        int cur = heights[row][col];
        DFS(heights,row + 1,col,diff,cur);
        DFS(heights,row - 1 ,col,diff,cur);
        DFS(heights,row  ,col + 1,diff,cur);
        DFS(heights,row ,col - 1,diff,cur);
        visited[row][col] = false;
    }

    public static void main(String[] args) {
        new D_1631().minimumEffortPath(new int[][]{{1,2,2},{3,8,2},{5,3,5}});
    }
}
