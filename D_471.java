package com.fengtin.LeetCode;

public class D_471 {
    public int findComplement(int num) {
        int ans = 0,p = 0;
        while(num > 0){
            ans += (num % 2 == 1? 0 : 1) * Math.pow(2,p++);
            num /= 2;
        }
        return ans;
    }
}
