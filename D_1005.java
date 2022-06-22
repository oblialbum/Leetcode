package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0,n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if(nums[0] >= 0){
            if(k % 2 == 0){
                return sum;
            }
            else{
                return sum - 2 * nums[0];
            }
        }
        else{
            int cnt = 0,min = 101;
            for (int i = 0; i < n; i++) {
                if(nums[i] >= 0){
                    min = Math.min(min,Math.abs(nums[i]));
                    break;
                }
                min = Math.min(min,Math.abs(nums[i]));
                cnt++;
            }
            sum = 0;
            if(k < cnt){
                for (int i = 0; i < n; i++) {
                    if(i < cnt && i >= k){
                        sum += nums[i];
                    }
                    else{
                        sum += Math.abs(nums[i]);
                    }
                }
                return sum;
            }
            else{
                for (int i = 0; i < n; i++) {
                    sum += Math.abs(nums[i]);
                }
                if((k - cnt) % 2 == 0){
                    return sum;
                }
                else{
                    return sum - 2 * min;
                }
            }
        }
    }

    public static void main(String[] args) {
        new D_1005().largestSumAfterKNegations(new int[]{2,-3,-1,5,-4},2);
    }
}
