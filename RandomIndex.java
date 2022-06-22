package com.fengtin.LeetCode;

import java.util.*;

public class RandomIndex {
    Map<Integer, List<Integer>> map;
    Random random;
    public RandomIndex(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        random = new Random();
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(random.nextInt(list.size()));
    }
}
