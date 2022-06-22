package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class FindSumPairs {
    int[] nums1;
    int[] nums2;
    Map<Integer, Integer> map1 ;
    Map<Integer,Integer> map2 ;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i],map1.getOrDefault(nums1[i],0)+1);
        }
        for (int i = 0; i < nums2.length; i++) {
            map2.put(nums2[i],map2.getOrDefault(nums2[i],0)+1);
        }
    }

    public void add(int index, int val) {
        map2.put(nums2[index], map2.get(nums2[index]) - 1);
        nums2[index] += val;
        map2.put(nums2[index], map2.getOrDefault(nums2[index],0) + 1);
    }

    public int count(int tot) {
        int res = 0;
        for (Map.Entry<Integer,Integer> entry: map1.entrySet()
             ) {
            int first = entry.getKey();
            if(map2.containsKey(tot - first)){
                res += entry.getValue() * map2.get(tot - first);
            }
        }
        return res;
    }
}
