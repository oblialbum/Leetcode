package com.fengtin.LeetCode;

public class D_31 {
    /**
     * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
     *
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）
     * 原地修改。
     * 暴力解法无了。
     * 存在逆序对，则有下一个更大的排列，否则无。
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        /**
         * 找第一个顺序对
         */
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        if(i >=0){
            int j = nums.length - 1;
            /**
             * 找一个比a[i]的的最小数
             */
            while(j >= 0 && nums[i] >= nums[j]){
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        reverse(nums,i+1);
    }

    private void reverse(int[] nums, int start) {
        int left = start,right = nums.length - 1;
        for(;left< right;){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
