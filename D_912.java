package com.fengtin.LeetCode;

import java.util.Random;

public class D_912 {
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if(left < right) {
            int index = partition(nums, left, right);
            quickSort(nums, left, index - 1);
            quickSort(nums, index + 1, right);
        }
    }

    /**
     * 分为俩部分
     * [left,i]: <=
     * [i + 1,right]:>
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right) {
        int shuffle = new Random().nextInt(right - left) + left;
        swap(nums, left, shuffle);
        int pivot = nums[left];
        int i = left - 1;
        for (int j = left; j <= right; j++) {
            if(nums[j] <= pivot){
                i++;
                swap(nums,i,j);
            }
        }
        swap(nums,i,left);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
