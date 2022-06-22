package com.fengtin.LeetCode;

public class D_744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        if (target >= letters[n - 1]){
            return letters[0];
        }else{
            for (int i = 0; i < n; i++) {
                if (letters[i] > target){
                    return letters[i];
                }
            }
        }
        return '1';
    }
}
