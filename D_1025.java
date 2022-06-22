package com.fengtin.LeetCode;

public class D_1025 {
    public boolean divisorGame(int n) {
        /**
         * dp[n]:对于当前数字N，先手操作的是否会赢。
         */
        boolean[] dp = new boolean[n + 1];
        dp[1] = false;
        if(n == 1){
            return dp[n];
        }
        dp[2] = true;
        for(int i = 3;i <= n;i++){
            /**
             * 爱丽丝先手
             */
            boolean flag  = false;
            for(int x = 1;x < i && i % x == 0;x++){
                /**
                 * 鲍勃在该数字下现手是否会赢。
                 */
                if(!dp[i - x]){
                    flag = true;
                    break;
                }
            }
            dp[i] = flag;
        }
        return dp[n];
    }
    public static void main(String[] args){
        new D_1025().divisorGame(576);
    }
}
