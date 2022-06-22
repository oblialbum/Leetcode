package com.fengtin.LeetCode;

import java.util.TreeMap;

public class D_846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0){
            return false;
        }
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int num:hand
             ) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        while (map.size() > 0){
            int min = map.firstKey();
            if (map.get(min) == 1){
                map.remove(min);
            }else {
                map.put(min, map.get(min) - 1);
            }
            for (int i = 1; i < groupSize; i++) {
                if (!map.containsKey(min + 1)){
                    return false;
                }
                if (map.get(min + 1) == 1){
                    map.remove(min + 1);
                }else {
                    map.put(min + 1, map.get(min + 1) - 1);
                }
                min++;
            }
        }
        return true;
    }
    
}
