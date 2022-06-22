package com.fengtin.LeetCode;

public class D_1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        int p = 0;
        for(int i = 0;i < 2 * n;i += 2){
            ans[i] = nums[p];
            ans[i + 1] = nums[p + n];
            p++;
        }
        return ans;
    }
}
