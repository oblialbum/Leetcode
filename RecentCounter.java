package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecentCounter {
    List<Integer> list ;
    public RecentCounter() {
        list = new ArrayList<>();
    }

    public int ping(int t) {
        list.add(t);
        int idx = Collections.binarySearch(list,t-3000);
        return list.size() - (idx >= 0 ? idx : -idx - 1);
    }

}