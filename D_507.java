package com.fengtin.LeetCode;

public class D_507 {
    public boolean checkPerfectNumber(int num) {
        if(num == 1){
            return  false;
        }
        int ans = 1;
        for(int i = 2;i <= Math.sqrt(num);i++){
            if(num % i == 0){
                ans += i + num / i;
            }
        }
        if(num == Math.sqrt(num) * Math.sqrt(num)){
            num -= Math.sqrt(num);
        }
        return ans == num;
    }
}
