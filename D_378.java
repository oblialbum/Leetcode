package com.fengtin.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class D_378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        for (int i = 0; i < n ; i++) {
            minHeap.offer(new int[]{matrix[i][0],i,0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] cur = minHeap.poll();
            if(cur[2] != n - 1){
                minHeap.offer(new int[]{matrix[cur[1]][cur[2] + 1],cur[1],cur[2] + 1});
            }
        }
        return minHeap.poll()[0];
    }
}
