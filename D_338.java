package com.fengtin.LeetCode;

public class D_338 {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        if(n == 0){
            return ans;
        }
        ans[0] = 0;
        ans[1] = 1;
        int multi = 1;
        for (int i = 2; i <= n; i++) {
            if(i == multi * 2){
                multi *= 2;
                ans[i] = 1;
            }
            else{
                ans[i] = ans[i - multi] + 1;
            }
        }
        return ans;
    }
}
