package com.fengtin.LeetCode;

import java.util.*;

public class D_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(s.length() < p.length()){
            return ans;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (char c: p.toCharArray()
             ) {
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        /**
         * init
         * 删除value=0的key。
         * 为负，多出的个数。
         * 为正，缺少的个数。
         */
        for (int i = 0; i < p.length(); i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0) - 1);
        }
        Iterator ite = map.keySet().iterator();
        while (ite.hasNext()){
            char c = (char) ite.next();
            if(map.get(c) == 0){
                ite.remove();
            }
        }
        if(map.isEmpty()){
            ans.add(0);
        }
        for (int i = p.length(); i < s.length(); i++) {
            char c = s.charAt(i);
            char c1 = s.charAt(i - p.length());
            if(c == c1){
                if(map.isEmpty()){
                    ans.add(i - p.length() + 1);
                }
                continue;
            }
            map.put(c1,map.getOrDefault(c1,0) + 1);
            map.put(c,map.getOrDefault(c,0) - 1);
            if(map.get(c1) == 0){
                map.remove(c1);
            }
            if(map.get(c) == 0){
                map.remove(c);
            }
            if(map.isEmpty()){
                ans.add(i - p.length() + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new D_438().findAnagrams("cbaebabacd","abc");
    }
}
