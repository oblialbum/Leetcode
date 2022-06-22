package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        //(int)Math.ceil((double)6/6);
        Arrays.sort(nums);
        if(threshold == nums.length){
            return nums[nums.length - 1];
        }
        int n = nums.length;
        //二分查？肯定能过，有没有更简单的方法？
        int l = 1,r = nums[n - 1];
        while (l < r){
            int mid = l + (r - l) / 2;
            if(judge(mid,nums,threshold)){
                r = mid;
            }
            else{
                l= mid + 1;
            }
        }
        return l;
    }

    private boolean judge(int mid, int[] nums, int threshold) {
        int sum = 0;
        for (int num: nums
             ) {
            sum += (num - 1) / mid + 1;
        }
        return sum <= threshold;
    }

    public static void main(String[] args){
        new D_1283().smallestDivisor(new int[]{21212,10101,12121},1000000);
    }
}
