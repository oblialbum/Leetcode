package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_324 {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] res = nums.clone();
        Arrays.sort(res);
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = res[--n];
        }
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = res[--n];
        }
    }

    public static void main(String[] args) {
        new D_324().wiggleSort(new int[]{1,2,2,3,3});
    }
}
