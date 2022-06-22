package com.fengtin.LeetCode;

public class D_1823 {
    public int findTheWinner(int n, int k) {
        boolean[] visited = new boolean[n];
        int cnt = 0;
        int p = 0;
        for (int i = 0; cnt != n - 1 ; i++) {
            if (visited[i % n]){
                continue;
            }
            p++;
            if (p == k){
                visited[i % n] = true;
                p = 0;
                cnt++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                return i + 1;
            }
        }
        return -1;
    }
}
