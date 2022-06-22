package com.fengtin.LeetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class D_1481 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num:arr
             ) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        int res = map.size();
        PriorityQueue<int[]> min = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        for (Map.Entry<Integer,Integer> entry:map.entrySet()
             ) {
            min.offer(new int[]{entry.getKey(),entry.getValue()});
        }
        while (k > 0 && !min.isEmpty()){
            int[] cur = min.poll();
            if (k >= cur[1]){
                res--;
            }
            k -= cur[1];
        }
        return res;
    }
}
