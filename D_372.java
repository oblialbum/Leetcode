package com.fengtin.LeetCode;

public class D_372 {
    final int mod = 1337;
    public int superPow(int a, int[] b) {
        return dfs(a % mod,b,b.length - 1);
    }

    private int dfs(int a, int[] b, int pos) {
        if(pos == 0){
            return (pow(a,b[pos])) % mod;
        }
        int cur = pow(a,b[pos]) % mod;
        return (cur * pow(dfs(a,b,pos - 1),10)) % mod;
    }
    private int pow(int a,int b){
        int res = 1;
        a %= mod;
        while (b != 0){
            if((b & 1) != 0){
                res = res * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }
}
