package com.fengtin.LeetCode;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Solution2 {
    int size,m,n;
    Set<Integer> set ;
    Random random;
    public Solution2(int m, int n) {
        set = new HashSet<>();
        random = new Random();
        size = m * n;
        this.m = m;
        this.n = n;
    }

    public int[] flip() {
        int cur = random.nextInt(size);
        while (set.contains(cur)){
            cur = random.nextInt(size);
        }
        set.add(cur);
        return new int[]{cur / m,cur % n};
    }

    public void reset() {
        set.clear();
    }
}
