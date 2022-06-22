package com.fengtin.LeetCode;

public class D_231 {
    public boolean isPowerOfTwo(int n) {
        while (n > 1){
            if(n % 2 == 0){
                n /= 2;
            }
            else {
                return false;
            }
        }
        return n == 1;
    }
}
