package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class AllOne {
    Map<String,Integer> keyMap ;
    Map<Integer, HashSet<String>> cntMap ;
    int max ,min;
    public AllOne() {
        keyMap = new HashMap<>();
        cntMap = new HashMap<>();
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    public void inc(String key) {

    }

    public void dec(String key) {

    }

    public String getMaxKey() {
        return "";
    }

    public String getMinKey() {
        return "";
    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("c");
        allOne.inc("c");
        allOne.dec("b");
        allOne.dec("b");
        System.out.println(allOne.getMinKey());
        allOne.dec("a");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMaxKey());
    }
}
