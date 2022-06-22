package com.fengtin.LeetCode;


import java.util.TreeMap;

public class D_1438 {
    public int longestSubarray(int[] nums, int limit) {
        int res = 0,begin = 0,end = 0;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        while (end < nums.length){
            map.put(nums[end],map.getOrDefault(nums[end],0) + 1);
            while (map.lastKey() - map.firstKey() > limit){
                map.put(nums[begin],map.get(nums[begin]) - 1);
                if (map.get(nums[begin]) == 0){
                    map.remove(nums[begin]);
                }
                begin++;
            }
            res = Math.max(res,end - begin + 1);
            end++;
        }
        return res;
    }
}
