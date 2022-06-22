package com.fengtin.LeetCode;

import java.util.*;

public class D_890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        int n = pattern.length();
        Map<Character,Character> map = new HashMap<>();
        Set<Character> used = new HashSet<>();
        for (String word:words
             ) {
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (map.containsKey(pattern.charAt(i))){
                    if (map.get(pattern.charAt(i)) != word.charAt(i)){
                        flag = false;
                        break;
                    }
                }else {
                    if (used.contains(word.charAt(i))){
                        flag = false;
                        break;
                    }
                    map.put(pattern.charAt(i),word.charAt(i));
                    used.add(word.charAt(i));
                }
            }
            if (flag){
                res.add(word);
            }
            map.clear();
            used.clear();
        }
        return res;
    }
}
