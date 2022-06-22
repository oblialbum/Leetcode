package com.fengtin.LeetCode;

public class D_342 {
    public boolean isPowerOfFour(int n) {
        if(n < 0){
            return false;
        }
        while (n > 0){
            if(n == 1){
                return true;
            }
            if(n % 4 != 0){
                return false;
            }
            n /= 4;
        }
        return true;
    }

    public static void main(String[] args) {
        new D_342().isPowerOfFour(16);
    }
}
