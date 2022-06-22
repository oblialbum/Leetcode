package com.fengtin.LeetCode;

public class D_1446 {
    public int maxPower(String s) {
        if(s.length() == 1){
            return 1;
        }
        int max = 1,cnt = 1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i - 1)){
                cnt++;
            }
            else{
                max = Math.max(max,cnt);
                cnt = 1;
            }
        }
        return Math.max(cnt,max);
    }
}
