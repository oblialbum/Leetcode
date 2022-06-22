package com.fengtin.LeetCode;

import java.util.TreeMap;

public class D_1962 {
    public int minStoneSum(int[] piles, int k) {
        int res = 0;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int pile:piles
             ) {
            map.put(pile,map.getOrDefault(pile,0) + 1);
            res += pile;
        }
        while (k > 0 && !map.isEmpty()){
            int max = map.lastKey();
            int times = map.get(max);
            if (k >= times){
                k -= times;
                map.remove(max);
                res -= (max/2 * times);
                max -= max/2;
                map.put(max,map.getOrDefault(max,0) + times);
            }
            else{
                res -= (max /2 * k);
                break;
            }
        }
        return res;
    }
}
