package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D_1403 {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums.length == 1){
            list.add(nums[0]);
            return list;
        }
        int sum = 0,curSum = 0,n = nums.length;
        for (int num:nums
             ) {
            sum += num;
        }
        Arrays.sort(nums);
        for (int i = n - 1; i >= 0 ; i--) {
            curSum += nums[i];
            list.add(nums[i]);
            if(curSum > (double)sum / 2){
                return list;
            }
        }
        return null;
    }
}
