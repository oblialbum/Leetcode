package com.fengtin.LeetCode;

public class D_1414 {
    static int[] f = new int[100];
    static{
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; f[i - 1] <= Math.pow(10,9); i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
    }
    public int findMinFibonacciNumbers(int k) {
        if (k == 0){
            return 0;
        }
        if (k == 1){
            return 1;
        }
        int idx = 0;
        for (; idx < 100; idx++) {
            if (f[idx] > k){
                break;
            }
        }
        return findMinFibonacciNumbers(k - f[idx - 1]) + 1;
    }
}
