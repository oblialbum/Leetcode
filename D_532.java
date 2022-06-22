package com.fengtin.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class D_532 {
    public int findPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] - k)){
                res.add(nums[i] - k );
            }else if (set.contains(nums[i] + k)){
                res.add(nums[i]);
            }
            set.add(nums[i]);
        }
        return res.size();
    }

    public static void main(String[] args) {
        new D_532().findPairs(new int[]{6,2,9,3,9,6,7,7,6,4},3);
    }
}
