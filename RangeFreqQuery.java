package com.fengtin.LeetCode;

import java.util.*;

public class RangeFreqQuery {
    Map<Integer, ArrayList<Integer>> map ;
    int size;
    public RangeFreqQuery(int[] arr) {
        size = arr.length;
        map = new HashMap<>(size);
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> list = map.getOrDefault(arr[i],new ArrayList<>());
            list.add(i);
            map.put(arr[i],list);
        }
        for (ArrayList<Integer> list:map.values()
             ) {
            Collections.sort(list);
        }
    }

    public int query(int left, int right, int value) {
        ArrayList<Integer> list = map.getOrDefault(value,new ArrayList<>());
        if(list.isEmpty()){
            return 0;
        }
        if(left > list.get(list.size() - 1) || right < list.get(0)){
            return 0;
        }
        int low = 0,high = list.size() - 1;
        while (low < high){
            int mid = low + (high - low) / 2;
            if(list.get(mid) >= left){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        int pos1 = low;
        low = 0;
        high = list.size() -1;
        while (low < high){
            int mid = low + (high - low) / 2;
            if(list.get(mid) > right){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        int pos2 = low;
        while (list.get(pos2) > right){
            pos2--;
        }
        return pos2 - pos1 + 1;
    }

    public static void main(String[] args) {
        new RangeFreqQuery(new int[]{1,1,1,2,2}).query(0,1,2);
    }
}
