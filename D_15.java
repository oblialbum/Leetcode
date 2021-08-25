package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D_15 {
    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                if ((nums[j] + nums[k] + nums[i]) > 0) {
                    k--;
                    continue;
                }
                if ((nums[j] + nums[k] + nums[i]) < 0) {
                    j++;
                    continue;
                }
                if ((j > (i + 1)) && k < (nums.length - 1)) {
                    if ((nums[j] == nums[j - 1] || nums[k] == nums[k + 1])) {
                        j++;
                        continue;
                    }
                }
                List<Integer> list = new ArrayList<Integer>();
                list.add(nums[i]);
                list.add(nums[j]);
                list.add(nums[k]);
                ans.add(list);
                j++;
                k--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSum(a);
        System.out.println(list.size());
        for (List l : list
        ) {
            System.out.println(l);
        }
    }
}

