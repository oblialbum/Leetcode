package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_506 {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[][] ans = new int[n][2];
        for (int i = 0; i < n; i++) {
            ans[i][0] = score[i];
            ans[i][1] = i;
        }
        Arrays.sort(ans, (o1, o2) -> o1[0] - o2[0]);
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            if(i == n-1){
                res[ans[i][1]] = "Gold Medal";
            }
            else if(i == n- 2){
                res[ans[i][1]] = "Silver Medal";
            }
            else if(i == n- 3){
                res[ans[i][1]] = "Bronze Medal";
            }
            else{
                res[ans[i][1]] = "" +(n - i);
            }
        }
        return res;
    }
}
