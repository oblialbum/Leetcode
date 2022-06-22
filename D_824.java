package com.fengtin.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class D_824 {
    static Set<Character> set = new HashSet<>();
    static {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
    }
    public String toGoatLatin(String sentence) {
        StringBuilder sb = new StringBuilder();
        String[] split = sentence.split(" ");
        for (int i = 0; i < split.length; i++) {
            String word = split[i];
            if (set.contains(word.charAt(0))){
                sb.append(word);
                sb.append("ma");
            }else{
                sb.append(word.substring(1));
                sb.append(word.charAt(0));
                sb.append("ma");
            }
            for (int j = 0; j < i+1; j++) {
                sb.append('a');
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
