package com.fengtin.LeetCode;

public class D_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] a = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            a[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            a[c - 'a']--;
            if(a[c - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
