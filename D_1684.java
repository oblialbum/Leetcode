package com.fengtin.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class D_1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        int ans = words.length;
        Set<Character> set = new HashSet<>();
        for (char c: allowed.toCharArray()
             ) {
            set.add(c);
        }
        for (String s: words
             ) {
            for (char c: s.toCharArray()
                 ) {
                if(!set.contains(c)){
                    ans--;
                    break;
                }
            }
        }
        return ans;
    }
}
