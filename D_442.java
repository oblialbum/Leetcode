package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_442 {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != nums[nums[i] - 1]){
                swap(nums,i,nums[i] - 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 != i){
                res.add(nums[i]);
            }
        }
        return res;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
