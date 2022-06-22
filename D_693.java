package com.fengtin.LeetCode;

public class D_693 {
    public boolean hasAlternatingBits(int n) {
        int pre = -1,cur;
        while (n > 0){
            cur = n % 2;
            if (pre == cur){
                return false;
            }
            pre = cur;
            n /= 2;
        }
        return true;
    }
}
