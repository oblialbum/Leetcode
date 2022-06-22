package com.fengtin.LeetCode;

public class D_997 {
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n];
        int[] outDegree = new int[n];
        for (int[] t:trust
             ) {
            inDegree[t[1] - 1]++;
            outDegree[t[0] - 1]++;
        }
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == n - 1 && outDegree[i] == 0){
                return i + 1;
            }
        }
        return -1;
    }
}
