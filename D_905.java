package com.fengtin.LeetCode;

public class D_905 {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0,right = nums.length - 1;
        while (left < right){
            while (left < right && nums[left] % 2 == 0){
                left++;
            }
            while (right > left && nums[right] % 2 == 1){
                right--;
            }
            if (left >= right){
                break;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        new D_905().sortArrayByParity(new int[]{3,1,2,4});
    }
}
