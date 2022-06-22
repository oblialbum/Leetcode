package com.fengtin.LeetCode;

public class D_62 {
    /**
     * 高中数学题。
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int ans = 1;
        for(int i = m + n - 1;i >= m -1;i--){
            ans *= i;
        }
        for(int i = 2;i <= n;i++){
            ans /= i;
        }
        return ans;
    }
}
