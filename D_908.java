package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_908 {
    public int smallestRangeI(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        return max - min <= 2 * k ? 0 : max - min - 2 * k ;
    }
}
