package com.fengtin.LeetCode;

public class D_859 {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
            alpha[goal.charAt(i) - 'a']--;
        }
        for (int num: alpha
             ) {
            if(num!=0){
                return false;
            }
        }
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != goal.charAt(i)){
                cnt++;
            }
        }
        if(cnt == 2){
            return true;
        }
        else if(cnt == 0){
            for (int i = 0; i < s.length(); i++) {
                alpha[s.charAt(i) - 'a']++;
            }
            for (int num: alpha
            ) {
                if(num >= 2){
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
