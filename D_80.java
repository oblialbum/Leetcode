package com.fengtin.LeetCode;

public class D_80 {
    public int removeDuplicates(int[] nums) {

        int sameData = 1;
        int move = 0;
        /**
         * 无法处理最后一组元素数量超过2的情况。
         */
        for(int i = 1;i < nums.length;i++){
            if(nums[i] == nums[i - 1]){
                sameData++;
                nums[i - move] = nums[i];
                continue;
            }
            if(sameData > 2){
                 move += sameData - 2;
            }
            sameData = 1;
            nums[i - move] = nums[i];
        }
        /**
         * 对最后一组元素再次处理。
         */
        if(sameData > 2){
            move += sameData - 2;
        }
        return nums.length - move;
    }
}
