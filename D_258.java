package com.fengtin.LeetCode;

public class D_258 {
    public int addDigits(int num) {
        if(num < 10){
            return num;
        }
        int ans = 0;
        while (num > 0){
            ans += num % 10;
            num /= 10;
        }
        return addDigits(ans);
    }
}
