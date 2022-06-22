package com.fengtin.LeetCode;

import java.util.*;

public class D_884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] first = s1.split(" ");
        String[] second = s2.split(" ");
        List<String> res = new ArrayList<>();
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        for (String word:first
             ) {
            map1.put(word,map1.getOrDefault(word,0) + 1);
        }
        for (String word:second
        ) {
            map2.put(word,map2.getOrDefault(word,0) + 1);
        }
        for (String key:map1.keySet()
             ) {
            if (map1.get(key) == 1 && !map2.containsKey(key)){
                res.add(key);
            }
        }
        for (String key:map2.keySet()
        ) {
            if (map2.get(key) == 1 && !map1.containsKey(key)){
                res.add(key);
            }
        }
        Set<Character> set = new HashSet<>();
        return res.toArray(new String[]{});
    }
    private boolean check(String s){
        Set<Character> set = new HashSet<>();
        for (int i = 0;i < s.length();i++){
        set.add(s.charAt(i));
    }
        for (Character key:set
             ) {
        if (Character.isLowerCase(key)){
            if (!set.contains((char)(key - 32))){
                return false;
            }
        }
        if (Character.isUpperCase(key)){
            if (!set.contains((char)(key + 32))){
                return false;
            }
        }
    }
        return true;
    }
    public static void main(String[] args) {
        System.out.println('a' -'A');
        System.out.println((char)('a' - 32));
    }
}
