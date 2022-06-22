package com.fengtin.LeetCode;

public class D_66 {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length - 1; i >= 0;i--){
            int newNum = digits[i] + carry;
            if(newNum == 10){
                carry = 1;
                digits[i] = 0;
            }
            else{
                carry = 0;
                digits[i] = newNum;
                break;
            }
        }
        if(carry == 1){
            int[] ans = new int[digits.length + 1];
            for(int i = 1;i < ans.length - 1;i++){
                ans[i] = digits[i - 1];
            }
            ans[0] = 1;
            return ans;
        }
        return  digits;
    }
    public static void main(String[] args){
        new D_66().plusOne(new int[]{9,9,9});
    }
}
