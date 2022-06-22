package com.fengtin.LeetCode;

public class D_1791 {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        int[] occur = new int[n];
        for (int[] edge:edges
             ) {
            occur[edge[0]]++;
            occur[edge[1]]++;
        }
        for (int i = 0; i < n; i++) {
            if (occur[i] > 1){
                return i;
            }
        }
        return -1;
    }
}
