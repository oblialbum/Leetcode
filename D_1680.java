package com.fengtin.LeetCode;

public class D_1680 {
    final int mod = (int) (1e9+7);
    public int concatenatedBinary(int n) {
        long res = 0;
        int num = 1,shift = 2;
        for (int i = 1; i <= n; i++) {
            if (i == shift){
                num++;
                shift <<= 1;
            }
            res = ((res << num )% mod + i) % mod;
        }
        return (int)res;
    }


    public static void main(String[] args) {
        new D_1680().concatenatedBinary(100000);
    }
}
