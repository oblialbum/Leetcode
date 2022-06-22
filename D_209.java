package com.fengtin.LeetCode;

public class D_209 {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE,begin = 0,end = 0,sum = 0;
        for(;end < nums.length;end++){
            sum += nums[end];
            while(sum >= target){
                min = Math.min(min,end - begin + 1);
                sum -= nums[begin++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
