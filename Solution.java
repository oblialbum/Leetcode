package com.fengtin.LeetCode;

import java.util.Arrays;

public class Solution {
    int[] origion;
    int n;
    int[] populated;
    public Solution(int[] nums) {
        n = nums.length;
        origion = Arrays.copyOf(nums,n);
        populated = Arrays.copyOf(nums,n);
    }

    public int[] reset() {
        return origion;
    }

    public int[] shuffle() {
        for (int i = 0; i < n; i++) {
            int index = (int)(Math.random() * (n - i)) + i;
            swap(populated,i,index);
        }
        return populated;
    }

    private void swap(int[] populated, int i, int j) {
        int temp = populated[i];
        populated[i] = populated[j];
        populated[j] = temp;
    }
}
