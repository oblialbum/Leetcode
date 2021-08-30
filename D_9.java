package com.fengtin.LeetCode;

public class D_9 {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int y = x;
        double ans = 0;
        for(;y != 0;y /= 10){
            int temp = y % 10;
            ans *= 10;
            ans += temp;
        }
        return ans == x;
    }
}
