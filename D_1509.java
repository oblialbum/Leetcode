package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_1509 {
    /**
     * 最小值删去（0-3），最大值删去（3-0）.
     * @param nums
     * @return
     */
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n <= 4){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            res = Math.min(res,nums[n - 4 + i] - nums[i]);
        }
        return res;
    }
}
