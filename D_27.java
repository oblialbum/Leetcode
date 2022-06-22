package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_27 {
    /**
     * 暴力解法：遍历，删除（后续元素前移需要O(n)的时间）。n*n复杂度，
     * 不能新建数组，要在原地修改数组.
     */
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int begin = -1, end = -1;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] == val) && (i == 0 || (i > 0 && nums[i] != nums[i - 1]))) {
                begin = i;
            }
            if ((nums[i] == val) && (i == nums.length - 1 || (i < nums.length && nums[i] != nums[i + 1]))) {
                end = i;
                break;
            }
        }
        if (begin == -1) {
            return nums.length;
        }
        int numOfVal = end - begin + 1;
        for (int i = end + 1; i < nums.length; i++) {
            nums[begin++] = nums[i];
        }
        return nums.length - numOfVal;
    }
}
