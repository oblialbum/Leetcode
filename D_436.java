package com.fengtin.LeetCode;

import java.util.TreeMap;

public class D_436 {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] res = new int[n];
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(intervals[i][0])){
                map.put(intervals[i][0],i);
            }else{
                if (i < map.get(intervals[i][0])){
                    map.replace(intervals[i][0],i);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int right = intervals[i][1];
            res[i] = map.ceilingKey(right) == null ? -1: map.get(map.ceilingKey(right));
        }
        return res;
    }
}
