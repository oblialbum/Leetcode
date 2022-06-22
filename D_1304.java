package com.fengtin.LeetCode;

public class D_1304 {
    public int[] sumZero(int n) {
        int length = n / 2 * 2;
        int[] ans = new int[n];
        if(length != n){
            ans[length] = 0;
        }
        int val = 1;
        for(int i = 0;i < length;i+= 2){
            ans[i] =val;
            ans[i + 1] = -val;
            val++;
        }
        return ans;
    }
}
