package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class D_5907 {
    Map<Integer,Integer> map = new HashMap<>();
    public int nextBeautifulNumber(int n) {
        int begin = n + 1;
        while (true){
            if(judge(begin)){
                break;
            }
            begin++;
        }
        return begin;
    }

    private boolean judge(int begin) {
        map.clear();
        while(begin > 0){
            map.put(begin % 10,map.getOrDefault(begin % 10,0) + 1);
            begin /= 10;
        }
        for (int key: map.keySet()
             ) {
            if(map.get(key) != key){
                return false;
            }
        }
        return true;
    }
}
