package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class D_1189 {
    public int maxNumberOfBalloons(String text) {
        String balloon = "balloon";
        Map<Character,Integer> map = new HashMap<>();
        for (char c: text.toCharArray()
             ) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int min = Integer.MAX_VALUE;
        for (char c: balloon.toCharArray()
             ) {
            if (c == 'l'||c == 'o'){
                min = Math.min(min,map.getOrDefault(c,0) / 2);
                continue;
            }
            min = Math.min(min,map.getOrDefault(c,0));
        }
        return min;
    }
}
