package com.fengtin.LeetCode;

import java.util.*;

public class D_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s: strs
             ) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String sortedString = new String(ch);
            if(!map.containsKey(sortedString)){
                map.put(sortedString,new ArrayList<String>());
            }
            map.get(sortedString).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args){
        System.out.println(new D_49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
