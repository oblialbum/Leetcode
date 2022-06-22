package com.fengtin.LeetCode;

public class D_263 {
    public boolean isUgly(int n) {
        if(n == 1){
            return true;
        }
        boolean flag = true;
        while(flag){
            flag = false;
            if(n % 2 == 0){
                n /= 2;
                flag = true;
            }
            if(n % 3 == 0){
                n /= 3;
                flag = true;
            }
            if(n % 5 == 0){
                n/= 5;
                flag = true;
            }
        }
        return  n == 1;
    }
}
