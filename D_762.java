package com.fengtin.LeetCode;

public class D_762 {
    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime(i)){
                res++;
            }
        }
        return res;
    }

    private boolean isPrime(int n) {
        int res = 0;
        while (n > 0){
            if (n % 2 == 1){
                res++;
            }
            n /= 2;
        }
        if (res == 1){
            return false;
        }
        for (int i = 2; i < res; i++) {
            if (res % i == 0){
                return false;
            }
        }
        return true;
    }
}
