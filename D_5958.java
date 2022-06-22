package com.fengtin.LeetCode;

public class D_5958 {
    public long getDescentPeriods(int[] prices) {
        if(prices.length == 1){
            return 1;
        }
        long n = prices.length,begin = 0,end = 1;
        long res = 0;
        while (end < n){
            if(prices[(int) end] != prices[(int) (end - 1)] - 1){
                res += (end - begin) * (end - begin + 1)/ 2;
                begin = end;
            }
            end++;
        }
        res += (end - begin) * (end - begin + 1)/ 2;
        return res;
    }
}
