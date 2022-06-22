package com.fengtin.LeetCode;

public class D_415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int n = num1.length() - 1, m = num2.length() - 1;
        int temp = 0;
        for (; n >= 0 && m >= 0 ; n--,m--) {
            int sum = num1.charAt(n) - '0' + num2.charAt(m) - '0' + temp;
            temp = sum / 10;
            sb.append(sum % 10);
        }
        if(n < 0 && m < 0){
            if(temp != 0) {
                sb.append(temp);
            }
        }
        else if(n < 0){
            while (m >= 0){
                int sum = num2.charAt(m) - '0' + temp;
                temp = sum / 10;
                sb.append(sum % 10);
                m--;
            }
            if(temp != 0) {
                sb.append(temp);
            }
        }
        else{
            while (n >= 0){
                int sum = num1.charAt(n) - '0' + temp;
                temp = sum / 10;
                sb.append(sum % 10);
                n--;
            }
            if(temp != 0) {
                sb.append(temp);
            }
        }
        return sb.reverse().toString();
    }
}
