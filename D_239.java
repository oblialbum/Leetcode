package com.fengtin.LeetCode;

import java.util.PriorityQueue;

public class D_239 {
    public static void main(String[] args) {
        new D_239().maxSlidingWindow(new int[]{-7, -8, 7, 5, 7, 1, 6, 0}, 4);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, p = 0;
        int[] res = new int[n - k + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) ->(y[0] - x[0]));
        for (int i = 0; i < k; i++) {
            pq.add(new int[]{nums[i],i});
        }
        res[p++] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            pq.add(new int[]{nums[i],i});
            while (pq.peek()[1] <= i - k){
                pq.poll();
            }
            res[p++] = pq.peek()[0];
        }
        return res;
    }
}
