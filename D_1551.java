package com.fengtin.LeetCode;

public class D_1551 {
    public int minOperations(int n) {
        int res = 0;
        if(n % 2 == 0){
            n /= 2;
            res = n * n;
        }
        else{
            n /= 2;
            res = n * (n + 1);
        }
        return res;
    }
}
