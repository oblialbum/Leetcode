package com.fengtin.LeetCode;

import java.util.*;

public class D_373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length,m = nums2.length,p = 0;
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
            }
        });
        for (int i = 0; i < n ; i++) {
            minHeap.add(new int[]{i,0});
        }
        for (int i = 0; i < k && !minHeap.isEmpty(); i++) {
            int[] cur = minHeap.poll();
            ans.add(new ArrayList<Integer>(){{
                add(nums1[cur[0]]);
                add(nums2[cur[1]]);
            }});
            if(cur[1]+1 < m){
                minHeap.add(new int[]{cur[0],cur[1] + 1});
            }
        }
        return ans;
    }

    public static void main(String[] args){
        new D_373().kSmallestPairs(new int[]{1,7,11},new int[]{2,4,6},3);
    }
}
