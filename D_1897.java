package com.fengtin.LeetCode;

public class D_1897 {
    public boolean makeEqual(String[] words) {
        int[] alpha = new int[26];
        for (String word: words
             ) {
            for (char c: word.toCharArray()
                 ) {
                alpha[c-'a']++;
            }
        }
        for (int num: alpha
             ) {
            if(num % words.length != 0){
                return false;
            }
        }
        return true;
    }
}
