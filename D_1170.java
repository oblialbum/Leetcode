package com.fengtin.LeetCode;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class D_1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        TreeMap<Integer,Integer> map = new TreeMap<>((o1, o2) -> o2 - o1);
        for (String word:words
             ) {
            int res = f(word);
            map.put(res,map.getOrDefault(res,0) + 1);
        }
        map.descendingMap();
        Iterator<Map.Entry<Integer,Integer>> ite = map.entrySet().iterator();
        int prefix = 0;
        while (ite.hasNext()){
            Map.Entry<Integer,Integer> entry = ite.next();
            prefix += entry.getValue();
            entry.setValue(prefix);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int cur = f(queries[i]);
            if(map.lowerKey(cur) == null){
                res[i] = 0;
                continue;
            }
            res[i] = map.getOrDefault(map.lowerKey(cur),0);
        }
        return res;
    }

    private int f(String word) {
        int cnt = 0;
        char cur = word.charAt(0);
        for (char c:word.toCharArray()
             ) {
            if(c == cur){
                cnt++;
            }
            else if (c < cur){
                cur = c;
                cnt = 1;
            }
        }
        return cnt;
    }

}
