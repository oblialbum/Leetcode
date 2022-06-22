package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[(nums[i] - 1) % n] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
