package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class D_748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        Map<Character,Integer> ori = new HashMap<>();
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if(Character.isLowerCase(c)){
                ori.put(c,ori.getOrDefault(c,0) + 1);
            }
        }
        int len = Integer.MAX_VALUE;
        String res = "";
        Map<Character,Integer> cnt = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if(Character.isLowerCase(c)){
                    cnt.put(c,cnt.getOrDefault(c,0) + 1);
                }
            }
            if (check(ori,cnt)){
                if(words[i].length() < len){
                    len = words[i].length();
                    res = words[i];
                }
            }
            cnt.clear();
        }
        return res;
    }

    private boolean check(Map<Character, Integer> ori, Map<Character, Integer> cnt) {
        for (Map.Entry<Character,Integer> entry: ori.entrySet()
             ) {
            char key = entry.getKey();
            int val = entry.getValue();
            if(cnt.getOrDefault(key,0) < val){
                return false;
            }
        }
        return true;
    }
}
