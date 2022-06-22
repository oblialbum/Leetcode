package com.fengtin.LeetCode;

import java.util.PriorityQueue;

public class D_179 {
    /**
     * 30,307,3
     * 303073
     * 303307
     * 307303
     * 307330
     * 330307
     * 330730
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        if(nums.length == 1){
            return "" + nums[0];
        }
        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        for (int num:nums
             ) {
            pq.add(String.valueOf(num));
        }

        StringBuilder res = new StringBuilder();
        while (!pq.isEmpty()){
            res.append(pq.poll());
        }
        if(res.charAt(0) == '0'){
            return "0";
        }
        return res.toString();
    }
}
