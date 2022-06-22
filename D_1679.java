package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_1679 {
    public int maxOperations(int[] nums, int k) {
        int res = 0,n = nums.length;
        Arrays.sort(nums);
        if (nums[0] >= k){
            return res;
        }
        for (int i = 0,j = n - 1; i < j;) {
            if (nums[i] + nums[j] > k){
                j--;
            }else if (nums[i] + nums[j] < k){
                i++;
            }else{
                i++;
                j--;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new D_1679().maxOperations(new int[]{1,2,3,4},5);
    }
}
