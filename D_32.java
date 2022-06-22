package com.fengtin.LeetCode;

public class D_32 {
    public int longestValidParentheses(String s) {
        int left = 0,right = 0,res = 0,n = s.length();
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '('){
                left++;
            }
            else{
                right++;
            }
            if(right == left){
                res = Math.max(res,2 * left);
            }
            if(right > left){
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i = n - 1; i >= 0 ; i--) {
            if(s.charAt(i) == ')'){
                right++;
            }
            else{
                left++;
            }
            if(right == left){
                res = Math.max(res,2 * left);
            }
            if(right < left){
                left = 0;
                right = 0;
            }
        }
        return res;
    }
}
