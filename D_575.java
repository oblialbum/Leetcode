package com.fengtin.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class D_575 {
    public int distributeCandies(int[] candyType) {
        int maxSort = candyType.length / 2,curSort = 0;
        Set<Integer> set = new HashSet<>();
        for (int sort: candyType
             ) {
            set.add(sort);
        }
        curSort = set.size();
        return Math.min(curSort, maxSort);
    }
}
