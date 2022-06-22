package com.fengtin.LeetCode;

import java.util.*;

public class D_1345 {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i],list);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        set.add(0);
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int idx = cur[0],step = cur[1];
            if (idx == n - 1){
                return step;
            }
            int val = arr[idx];
            step++;
            if (map.containsKey(val)){
                for (int next:map.get(val)
                     ) {
                    if (set.add(next)){
                        queue.add(new int[]{next,step});
                    }
                }
                map.remove(val);
            }
            if (set.add(idx + 1) && idx + 1 < n){
                queue.add(new int[]{idx + 1,step});
            }
            if (set.add(idx - 1) && idx -1 >= 0){
                queue.add(new int[]{idx - 1,step});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new D_1345().minJumps(new int[]{2,2,34,5,6,7,8});
    }
}
