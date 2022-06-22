package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D_120 {
    /**
     * dp:到达当前位置的最小路径和。
     * @param triangle
     * @return
     */
    int[][] memo;
    int min = Integer.MAX_VALUE;
    public int minimumTotal(List<List<Integer>> triangle) {
        memo= new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        for(int i = 0;i < memo.length; i++){
            Arrays.fill(memo[i],Integer.MAX_VALUE);
        }
        dfs(triangle,0,0,triangle.get(0).get(0));
        return  min;
    }

    private void dfs(List<List<Integer>> triangle, int row, int column,int curSum) {
        if(row == triangle.size()){
            min = Math.min(min,curSum);
            return;
        }
        if(memo[row][column] > curSum){
            memo[row][column] = curSum;
        }
        else{
            return;
        }
        dfs(triangle,row+1,column,curSum+triangle.get(row + 1).get(column));
        dfs(triangle,row+1,column+1,curSum+triangle.get(row + 1).get(column + 1));
    }

        private int dP(List<List<Integer>> triangle) {
            if(triangle.size()  == 1){
                return triangle.get(0).get(0);
            }
            int[][] dp = new int[2][triangle.size()];
            dp[0][0] = triangle.get(0).get(0);
            for(int i = 1;i < triangle.size();i++){
                for(int j = 0;j < triangle.get(i).size();j++){
                    if(j == 0){
                        dp[1][j] = dp[0][j] + triangle.get(i).get(j);
                    }
                    else if(j == triangle.get(i).size() - 1){
                        dp[1][j] = dp[0][j - 1] + triangle.get(i).get(j);
                    }
                    else{
                        dp[1][j] = Math.min(dp[0][j],dp[0][j - 1]) + triangle.get(i).get(j);
                    }
                }
                for(int j = 0;j < triangle.get(i).size();j++){
                    dp[0][j] = dp[1][j];
                }
            }
            int min = Integer.MAX_VALUE;
            for (int sum: dp[1]
                 ) {
                min = Math.min(min,sum);
            }
            return min;
        }
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        List<List<Integer>> test = new ArrayList<>();
        test.add(list);
        new D_120().dP(test);
    }
}
