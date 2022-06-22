package com.fengtin.LeetCode;

public class D_67 {
    public String addBinary(String a, String b) {
        char[] ans = new char[Math.max(a.length(),b.length()) + 1];
        int carry = 0;
        for(int i = a.length()-1,j = b.length() - 1,k = ans.length - 1;i >= 0 && j >= 0;i--,j--,k--){
            int curNum = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
            ans[k] = (char)(curNum % 2 + '0');
            carry = curNum / 2;
        }
        if(a.length() >b.length()){
            for(int i = a.length() - b.length() - 1;i >= 0;i--){
                int curNum = a.charAt(i) - '0' +carry;
                ans[i + 1] = (char)(curNum % 2 + '0');
                carry = curNum / 2;
            }
        }
        else if(a.length() < b.length()){
            for(int i = b.length() - a.length() - 1;i >= 0;i--){
                int curNum = b.charAt(i) - '0' +carry;
                ans[i + 1] = (char)(curNum % 2 + '0');
                carry = curNum / 2;
            }
        }
        if(carry == 1){
            ans[0] = '1';
            return new String (ans);
        }
        return new String (ans).substring(1);
    }
}
