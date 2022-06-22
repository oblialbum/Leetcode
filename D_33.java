package com.fengtin.LeetCode;

public class D_33 {
    /**
     * 不能全部旋转，至少保留一个再第一部分。
     * @param nums
     * @param target
     * @return
     */
    int ans = -1;
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        /**
         * 找到数组分为俩部分的下标left,也是最小值处。
         */
        int left = 0,right = nums.length - 1,mid = -1;
        while(left < right){
            mid = left + (right - left)/2;
            if( nums[mid] > nums[right]){
                left = mid + 1;
            }
            if(nums[mid] < nums[right]){
                right = mid;
            }
        }
        if(nums[left] > target|| (left > 0 && nums[left - 1] < target)){
            return -1;
        }
        binarySearch(nums,left,nums.length - 1,target);
        binarySearch(nums,0,left - 1,target);
        return ans;
    }

    private void binarySearch(int[] nums, int left, int right,int target) {
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] > target){
                right = mid -1;
            }
            if(nums[mid] < target){
                left = mid + 1;
            }
            if(nums[mid] == target){
                ans = mid;
                return;
            }
        }
    }

    public static void main(String[] args){
        System.out.println(new D_33().search(new int[]{1},-1));
    }
}
