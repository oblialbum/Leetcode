package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0,n = citations.length - 1;
        while(n >= 0 && citations[n] > h){
            h++;
            n--;
        }
        return h;
    }
}
