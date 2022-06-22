package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_75 {
    public void sortColors(int[] nums) {
        if(nums.length  == 1){
            return;
        }
        if(nums.length == 2){
            Arrays.sort(nums);
            return;
        }
        /**
         * [0,zero):0
         * [zero,first):1
         * [first,nums.length):2
         */
        int zero = 0;
        int second = nums.length;
        int first = 0;
        for(;first < second;){
            if(nums[first] == 0){
                swap(nums,zero++,first);
                first++;
                continue;
            }
            if(nums[first] == 2){
                swap(nums,--second,first);
            }
            if(nums[first] == 1){
                first++;
            }
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        new D_75().sortColors(new int[]{2,0,1});
    }
}
