package com.fengtin.LeetCode;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class D_1 {
    public static void main(String args[]) {
        for (float x = 1; x < 100; x++) {
            for (float y = 1; y < 100; y++) {
                float result = y / x;
                if (result < 1.1 && result > (12.0 / 11)) {
                    System.out.println(result + ",x:" + x + ",y:" + y);
                }
            }
        }
    }

    private int[] twoSum(int @NotNull [] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
