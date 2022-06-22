package com.fengtin.LeetCode;

public class D_153 {
    public int findMin(int[] nums) {
        int l = 0,r = nums.length - 1   ;
        while (l < r){
            int mid = l + (r - l) /2;
            if(nums[mid] >nums[r]){
                l = mid + 1;
            }
            if(nums[mid] < nums[r]){
                r = mid;
            }
        }
        return nums[l];
    }
}
