package com.fengtin.LeetCode;

public class D_581 {
    /**
     * 第一步求左侧分割的下标。左侧有序且右侧最小值 >左侧最大值
     * 第一步求右侧分割的下标。右侧有序且右侧最小值 >左侧最大值
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int n = nums.length,low = -1,high = nums.length;
        int[] left = new int[n],right = new int[n];
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(nums[i],left[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(nums[i],right[i + 1]);
        }
        /**
         * 最后一次使不等式i成立的则为low.
         * low:结果以该位置的下一个为起始点。
         */
        for (int i = 0; i < n - 1; i++) {
            if(left[i] <= right[i + 1]){
                low = i;
            }
            else {
                break;
            }
        }
        /**
         * 有序
         */
        if(low == n - 2){
            return 0;
        }

        for (int i = n-1; i >= 1; i--) {
            if(left[i - 1] <= right[i]){
                high = i;
            }
            else {
                break;
            }
        }
        return high - low -1;
    }

    public static void main(String[] args) {
        new D_581().findUnsortedSubarray(new int[]{1,2,3,4});
    }
}
