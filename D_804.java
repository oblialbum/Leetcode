package com.fengtin.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class D_804 {
    static String[] pwd = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word:words
             ) {
            StringBuilder sb = new StringBuilder();
            for (char c:word.toCharArray()
                 ) {
                sb.append(pwd[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
