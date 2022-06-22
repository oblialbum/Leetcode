package com.fengtin.LeetCode;

import java.util.*;

public class D_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for (int num: nums1
             ) {
            set.add(num);
        }
        for(int i = 0;i < nums2.length;i++){
            if(i > 0 && nums2[i] == nums2[i - 1]){
                continue;
            }
            if(set.contains(nums2[i])){
                list.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int[] ans = new int[list.size()];
        for(int i = 0;i < ans.length;i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
