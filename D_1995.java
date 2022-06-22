package com.fengtin.LeetCode;

public class D_1995 {
    public int countQuadruplets(int[] nums) {
        int cnt = 0,n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j+ 1; k < n; k++) {
                    for (int l = k+ 1; l < n; l++) {
                        if (nums[i]+ nums[j] + nums[k] == nums[l]){
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
