package com.fengtin.LeetCode;

public class D_540 {
    /**
     * 该元素左右两边各有偶数个元素，在偶数下标范围内进行二分查找。该元素下标一定为偶数。
     * 设该下标为x，在x之前，均是（2i，2i+1）相等的情况。在x出现之后，（2i,2i+1）时不相等的。
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int low = 0,high = nums.length - 1;
        while (low < high){
            int mid = low + (high - low) / 2;
            if (mid % 2 == 1){
                mid -= 1;
            }
            if (nums[mid] == nums[mid + 1]){
                low = mid + 2;
            }else{
                high = mid;
            }
        }
        return nums[low];
    }
}
