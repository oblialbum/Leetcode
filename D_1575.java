package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_1575 {
    int[][] memo;
    int mod = (int)(Math.pow(10,9)) + 7;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        memo = new int[locations.length][fuel + 1];
        for(int i = 0;i < memo.length;i++){
            Arrays.fill(memo[i],-1);
        }
        return dfs(locations,start,finish, fuel) % mod;
    }

    private int dfs(int[] locations, int start, int finish, int fuel) {
        /**
         * 可以走重复的城市，终点也可以到达不止一次。
         */
        if(memo[start][fuel] != -1){
            return memo[start][fuel];
        }
        memo[start][fuel] = (start == finish ? 1 : 0) ;
        /**
         * 剪枝一：当前城市直接到达目的地的油耗大于当前油量。
         */
        if(Math.abs(locations[start] - locations[finish]) > fuel){
            return 0;
        }
        for(int i = 0;i < locations.length;i++){
            if(i == start){
                continue;
            }
            /**
             * 剪枝二：油量不足。
             */
            if(Math.abs(locations[start] - locations[i]) > fuel){
                continue;
            }
            memo[start][fuel] += dfs(locations,i,finish,fuel - Math.abs(locations[start] - locations[i]));
            memo[start][fuel] %= mod;
        }
        return memo[start][fuel];
    }

    public int countRoutesByDP(int[] locations, int start, int finish, int fuel){
        int n = locations.length;
        int[][] DP = new int[n][fuel + 1];
        int mod = (int)(Math.pow(10,9)) + 7;
        /**
         * 初始话DP,油量为0时，每个城市到达目的地的路线数量。
         */
        for(int i = 0;i < n;i++){
            if(i == finish){
                DP[i][0] = 1;
                continue;
            }
            DP[i][0] = 0;
        }
        for(int i = 0;i <= fuel;i++){
            DP[finish][i] = 1;
        }
        for(int col = 1;col <= fuel;col++){
            for(int row = 0;row < n;row++){
                for(int i = 0;i < n;i++){
                    if(i == row){
                        continue;
                    }
                    /**
                     * 当前油量下，该城市能够抵达的其他城市。
                     */
                    if(col - Math.abs(locations[row] - locations[i]) < 0){
                        continue;
                    }
                    DP[row][col] += DP[i][col - Math.abs(locations[row] - locations[i])];
                }
                DP[row][col] %= mod;
            }
        }
        /**
         * 目的：求DP[start][fuel]。
         */
        return DP[start][fuel];
    }

    public static void main(String[] args){
        new D_1575().countRoutesByDP(new int[]{1,2,3},0,2,40);
    }
}
