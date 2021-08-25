package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_494 {
    public static int findTargetSumWays(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0;i < nums.length;i++){
            sum += nums[i];
        }
        if(target > sum || target < (sum * -1)){
            return 0;
        }
        /**
         * difference代表的是在dfs中找到和为difference的子集的数量，可以重复。
         */
        if((sum - Math.abs(target)) % 2 == 1){
            return 0;
        }
        int difference = (sum - Math.abs(target)) / 2;
        if(difference == 0){
            int count = 0;
            for(int i = 0;i < nums.length;i++){
                count += nums[i] == 0 ? 1 : 0;
            }
            return (int) Math.pow(2,count);
        }
        return dfs(nums,difference,0);
    }
    private static int dfs(int[] nums,int target,int pos){
        if(target == 0){
            return 1;
        }
        int count = 0;
        for(int i = pos;i < nums.length;i++){
            if(nums[i] >target) {
                break;
            }
            count += dfs(nums,target - nums[i],i+1);
        }

        return count;
    }

    public static void main(String[] args){
        System.out.println(findTargetSumWays(new int[]{1,0},1));
    }
}
