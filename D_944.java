package com.fengtin.LeetCode;

public class D_944 {
    public int minDeletionSize(String[] strs) {
        int m = strs.length,n = strs[0].length(),res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)){
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
