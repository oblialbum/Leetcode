package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class D_76 {
    Map<Character,Integer> ori = new HashMap<>();
    Map<Character,Integer> cnt = new HashMap<>();
    public String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            ori.put(t.charAt(i),ori.getOrDefault(t.charAt(i),0)+1);
        }
        int l = 0,r = 0,len = Integer.MAX_VALUE,ansL = -1,ansR = -1;
        for (; r < s.length(); r++) {
            if(ori.containsKey(s.charAt(r))){
                cnt.put(s.charAt(r),cnt.getOrDefault(s.charAt(r),0)+1);
            }
            while (check() && l <= r){
                if(r - l + 1 < len){
                    len = r - l + 1;
                    ansL = l;
                    ansR = r;
                }
                if (ori.containsKey(s.charAt(l))){
                    cnt.put(s.charAt(l),cnt.getOrDefault(s.charAt(l),0) - 1);
                }
                l++;
            }
        }
        return ansR == -1 ? "" : s.substring(ansL,ansR+1);
    }

    private boolean check() {
        for (Map.Entry<Character,Integer> entry:ori.entrySet()
             ) {
            char key = entry.getKey();
            int val = entry.getValue();
            if(val > cnt.getOrDefault(key,0)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new D_76().minWindow("cabwefgewcwaefgcf","cae");
    }
}
