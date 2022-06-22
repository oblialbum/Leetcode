package com.fengtin.LeetCode;

public class D_189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if(k == 0){
            return;
        }
        for (int i = 0,j = n - k - 1; i <= j; i++,j--) {
            swap(nums,i,j);
        }
        for (int i = n - 1,j = n - k; i >= j ; i--,j++) {
            swap(nums,i,j);
        }
        for (int i = 0,j = n - 1; i <= j; i++,j--) {
            swap(nums,i,j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
