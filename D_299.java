package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class D_299 {
    public String getHint(String secret, String guess) {
        int n = secret.length(),Bulls = 0,Cows = 0;
        Set<Integer> index = new HashSet<>();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(secret.charAt(i) == guess.charAt(i)){
                index.add(i);
                Bulls++;
            }
            else {
                map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if(!index.contains(i)){
                if(map.containsKey(guess.charAt(i)) && map.get(guess.charAt(i)) != 0){
                    map.replace(guess.charAt(i),map.get(guess.charAt(i)) - 1);
                    Cows++;
                }
            }
        }
        return "" + Bulls +'A' + Cows + 'B';
    }
}
