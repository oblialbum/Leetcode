package com.fengtin.LeetCode;

public class D_713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length,left = 0,right = 0;
        int cur = 1,res = 0;
        while (right < n){
            cur *= nums[right];
            if (cur >= k){
                int len = right - left;
                if (len == 0){
                    cur /= nums[left];
                    left++;
                }else{
                    while (cur >= k){
                        res += len--;
                        cur /= nums[left++];
                    }
                }
            }
            right++;
        }
        if (right != left){
            res += (right - left) * (right - left + 1) / 2;
        }
        return res;
    }

    public static void main(String[] args) {
        new D_713().numSubarrayProductLessThanK(new int[]{10,5,2,6},100);
    }
}
