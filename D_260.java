package com.fengtin.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class D_260 {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums
             ) {
            if(set.contains(num)){
                set.remove(num);
            }
            else{ set.add(num);}
        }
        int[] ans = new int[set.size()];
        int i = 0;
        for (int num: set
             ) {
            ans[i++] = num;
        }
        return ans;
    }
}
