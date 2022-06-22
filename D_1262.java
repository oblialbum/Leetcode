package com.fengtin.LeetCode;

public class D_1262 {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] DP = new int[n][3];
        DP[0][0] = (nums[0] % 3 == 0 ? nums[0] : 0);
        DP[0][1] = (nums[0] % 3 == 1 ? nums[0] : 0);
        DP[0][2] = (nums[0] % 3 == 2 ? nums[0] : 0);
        for(int i = 1;i < n;i++){
            int a = DP[i - 1][0] + nums[i];
            int b = DP[i - 1][1] + nums[i];
            int c = DP[i - 1][2] + nums[i];
            DP[i][a % 3] = Math.max(Math.max(DP[i][a % 3],a),DP[i - 1][a % 3]);
            DP[i][b % 3] = Math.max(Math.max(DP[i][b % 3],b),DP[i - 1][b % 3]);
            DP[i][c % 3] = Math.max(Math.max(DP[i][c% 3],c),DP[i - 1][c % 3]);
            /**
             * 有的值可能没更新到。
             */
            for(int j = 0;j < 3;j++){
                if(DP[i][j] == 0){
                    DP[i][j] = DP[i - 1][j];
                }
            }
        }
        return DP[n - 1][0];
    }
    public  static void main(String[] args){
        new D_1262().maxSumDivThree(new int[]{3,6,5,1,8});
    }
}
