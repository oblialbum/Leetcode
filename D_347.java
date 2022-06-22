package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class D_347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num: nums
             ) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(k,(o1, o2) -> o1[1] - o2[1]);
        for (Map.Entry<Integer,Integer> entry:map.entrySet()
             ) {
            int val = entry.getValue();
            int key = entry.getKey();
            if(pq.size() < k){
                pq.offer(new int[]{key,val});
            }
            else{
                if(pq.peek()[1] < val){
                    pq.poll();
                    pq.offer(new int[]{key,val});
                }
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = pq.poll()[0];
        }
        return ret;
    }
}
