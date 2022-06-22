package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_1021 {
    List<String> res ;
    public String removeOuterParentheses(String s) {
        res = new ArrayList<>();
        solve(s);
        String ans = "";
        for (String item: res
             ) {
            ans += item;
        }
        return ans;
    }

    private void solve(String s) {
        int balance = 0,pre = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                balance++;
            }else{
                balance--;
            }
            if (balance == 0){
                res.add(s.substring(pre + 1,i));
                pre = i + 1;
            }
        }
    }
}
