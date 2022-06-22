package com.fengtin.LeetCode;

public class D_334 {
    /**
     * 找到一个递增子序列（nums[i] < nums[j] < nums[k]）,i < j < k.
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3){
            return false;
        }
        int n = nums.length;
        int[] left_min = new int[n];
        int[] right_max = new int[n];
        left_min[0] = nums[0];
        right_max[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            left_min[i] = Math.min(left_min[i - 1],nums[i]);
        }
        for (int i = n - 2; i >= 0 ; i--) {
            right_max[i] = Math.max(right_max[i + 1],nums[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] < right_max[i + 1] && nums[i] > left_min[i - 1]){
                return true;
            }
        }
        return false;
    }
}
