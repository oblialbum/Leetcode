package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class D_953 {
    Map<Character,Integer> map;
    public boolean isAlienSorted(String[] words, String order) {
        map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i),i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (compare(words[i],words[i + 1]) > 0){
                return false;
            }
        }
        return true;
    }

    private int compare(String first, String second) {
        if (first.equals(second)){
            return 0;
        }
        int m = first.length(),n = second.length();
        for (int i = 0; i < Math.min(m,n); i++) {
            if (map.get(first.charAt(i)) < map.get(second.charAt(i))){
                return -1;
            }
            if (map.get(first.charAt(i)) > map.get(second.charAt(i))){
                return 1;
            }
        }
        return m - n;
    }
}
