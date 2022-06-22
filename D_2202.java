package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_2202 {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length,res = -1;
        if (n == 1 ){
            if (k % 2 == 1) {
                return -1;
            }else{
                return nums[0];
            }
        }
        if (k <= n){
            for (int i = 0; i < k - 1; i++) {
                res = Math.max(nums[i],res);
            }
            if (k < n){
                res = Math.max(nums[k],res);
            }
        }else{
            res = Arrays.stream(nums).max().getAsInt();
        }
        return res;
    }
}
