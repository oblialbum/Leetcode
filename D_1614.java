package com.fengtin.LeetCode;

public class D_1614 {
    public int maxDepth(String s) {
        int balance = 0,res = 0;
        for (char c: s.toCharArray()
             ) {
            if (c == '('){
                balance++;
            }else if (c == ')'){
                balance--;
            }else{
                continue;
            }
            if (balance < 0){
                return -1;
            }
            res = Math.max(res,balance);
        }
        return balance;
    }
}
