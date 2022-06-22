package com.fengtin.LeetCode;

public class D_1556 {
    public String thousandSeparator(int n) {
        if (n == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0){
            int temp = n % 1000;
            sb.insert(0,temp);
            while (temp < 100){
                sb.insert(0,0);
                temp *= 10;
            }
            n /= 1000;
            sb.insert(0,'.');
        }
        sb.deleteCharAt(0);
        while (sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
