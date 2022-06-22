package com.fengtin.LeetCode;

public class D_2104 {
    public long subArrayRanges(int[] nums) {
        long res = 0;
        int n = nums.length;
        int max,min;
        for (int i = 0; i < n; i++) {
            max = nums[i];
            min = nums[i];
            for (int j = i+1; j < n; j++) {
                max = Math.max(max,nums[j]);
                min = Math.min(min,nums[j]);
                res += max - min;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new D_2104().subArrayRanges(new int[]{1,3,3});
    }
}
