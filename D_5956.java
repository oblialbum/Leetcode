package com.fengtin.LeetCode;

public class D_5956 {
    public String firstPalindrome(String[] words) {
        for (String word:words
             ) {
            if(huiWen(word)){
                return word;
            }
        }
        return "";
    }

    private boolean huiWen(String word) {
        for (int i = 0,j = word.length() - 1; i < j; i++,j--) {
            if(word.charAt(i) != word.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
