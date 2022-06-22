package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class D_205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<Character,Character>();
        Set<Character> set = new HashSet<Character>();
        for(int i = 0;i < s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                if(set.contains(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i),t.charAt(i));
                set.add(t.charAt(i));
            }
            else{
                if(t.charAt(i) != map.get(s.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }
}
