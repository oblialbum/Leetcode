package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_1051 {
    public int heightChecker(int[] heights) {
        int[] copy = Arrays.copyOf(heights,heights.length);
        int res = 0;
        Arrays.sort(copy);
        for (int i = 0; i < heights.length; i++) {
            if(heights[i] != copy[i]){
                res++;
            }
        }
        return res;
    }
}
