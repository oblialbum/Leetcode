package com.fengtin.LeetCode;

public class D_520 {
    public boolean detectCapitalUse(String word) {
        if(word.length() == 1){
            return true;
        }
        int n = word.length(),index = -1,count = 0;
        for (int i = 0; i < n; i++) {
            if(Character.isUpperCase(word.charAt(i))){
                count++;
                index = i;
            }
        }
        if(count == n){
            return true;
        }
        return (count == 1 && index == 0) ||count == 0;
    }
}
