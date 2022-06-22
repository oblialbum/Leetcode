package com.fengtin.LeetCode;

public class D_390 {
    public int lastRemaining(int n) {
        return kernal(n, 0);
    }
    private int kernal(int n, int flag) {
        if(n == 1) {
            return 1;
        }
        int index = kernal(n/2, flag ^ 1);
        return flag == 0 ? 0 + index * 2 : n + 1 - (n/2 - index + 1) * 2;
    }
}
