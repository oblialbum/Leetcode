package com.fengtin.LeetCode;

import java.util.*;

public class RandomizedSet {
    Map<Integer,Integer> map;
    List<Integer> list;
    int size;
    Random random;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        size = 0;
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        }
        map.put(val,size);
        list.add(val);
        size++;
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)){
            return false;
        }
        int idx = map.get(val);
        map.replace(list.get(size - 1),idx);
        Collections.swap(list,idx,size - 1);
        list.remove(size-1);
        map.remove(val);
        size--;
        return true;
    }

    public int getRandom() {
        int idx = random.nextInt(size);
        return list.get(idx);
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        set.insert(1);
        set.insert(2);
        set.insert(3);
        set.remove(3);
        System.out.println(set.getRandom());
    }
}
