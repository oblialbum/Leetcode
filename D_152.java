package com.fengtin.LeetCode;

public class D_152 {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int[] dpMin = new int[nums.length];
        int[] dpMax = new int[nums.length];
        dpMin[0] = max;
        dpMax[0] = max;
        for(int i = 1;i <nums.length;i++){
            dpMin[i] = Math.min(dpMin[i - 1] * nums[i], Math.min(nums[i],dpMax[i - 1] * nums[i]));
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], Math.max(nums[i],dpMin[i - 1] * nums[i]));
        }
        for(int i = 1;i < nums.length;i++){
            max = Math.max(max,dpMax[i]);
        }
        return max;
    }

    public static void main(String[] args){
        int[] nums = new int[]{3,-1,4};
        new D_152().maxProduct(nums);
    }
}
