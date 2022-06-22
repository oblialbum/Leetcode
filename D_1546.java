package com.fengtin.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class D_1546 {
    public int maxNonOverlapping(int[] nums, int target) {
        int n = nums.length;
        int ret = 0,i = 0;
        while (i < n){
            Set<Integer> set = new HashSet<Integer>() {{
                add(0);
            }};
            int sum = 0;
            while(i < n){
                sum += nums[i];
                if(set.contains(sum - target)){
                    ret++;
                    break;
                }
                else{
                    set.add(sum);
                    i++;
                }
            }
            i++;
        }
        return ret;
    }
}
