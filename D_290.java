package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王鑫
 */
public class D_290 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> hashMap1 = new HashMap<>();
        Map<String,Character> hashMap2 = new HashMap<>();
        int pos = 0,end = 0;
        for(int begin = 0;end < s.length() && pos < pattern.length();end++){
            if(s.charAt(end) == ' ' || end == s.length() - 1){
                if(end == s.length() - 1){
                    end++;
                }
                if(hashMap1.containsKey(pattern.charAt(pos)) || hashMap2.containsKey(s.substring(begin,end))){
                    if(!hashMap1.getOrDefault(pattern.charAt(pos),"").equals(s.substring(begin,end))){
                        return false;
                    }
                    if(!hashMap2.getOrDefault(s.substring(begin,end),' ').equals(pattern.charAt(pos))){
                        return false;
                    }
                }
                else{
                    hashMap1.put(pattern.charAt(pos),s.substring(begin,end));
                    hashMap2.put(s.substring(begin,end),pattern.charAt(pos));
                }
                begin = end + 1;
                pos++;
            }
        }
        return pos == pattern.length() && end == s.length() + 1;
    }

    public static void main(String[] args){
        new D_290().wordPattern("abba","dog cat cat dog");
    }
}
