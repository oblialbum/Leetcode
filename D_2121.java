package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class D_2121 {
    public long[] getDistances(int[] arr) {
        long[] res = new long[arr.length];
        Map<Integer, ArrayList<Long>> map = new HashMap<>();
        for (int i = 0; i < res.length; i++) {
            ArrayList<Long> list = map.getOrDefault(arr[i], new ArrayList<>());
            if (list.isEmpty()) {
                list.add((long) i);
                map.put(arr[i],list);
            }else{
                list.add(list.get(list.size() - 1) + i);
            }
        }
        Map<Integer,Long> cnt = new HashMap<>();
        map.forEach((x,y)-> cnt.put(x,0L));
        for (int i = 0; i < res.length; i++) {
            ArrayList<Long> list = map.get(arr[i]);
            if (list.size() == 1){
                res[i] = 0;
            }else{
                int n = list.size();
                long idx = cnt.get(arr[i]);
                cnt.put(arr[i], (idx + 1));
                if (i == list.get(0)){
                    res[i] = list.get(n - 1) -list.get(0) - (n - 1) * i ;
                }else if(i == list.get(n - 1)){
                    res[i] = (n - 1) * i - list.get(n - 2);
                }else{
                    res[i] = idx * i - list.get((int)idx - 1) + list.get(n - 1) - list.get((int) idx) -(n - idx - 1) * i;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new D_2121().getDistances(new int[]{10,5,10,10});
    }
}
