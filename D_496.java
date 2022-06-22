package com.fengtin.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class D_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Arrays.fill(ans,-1);
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i],i);
        }
        for (int i = 0; i < nums1.length; i++) {
            int pos = map.get(nums1[i]);
            if(pos == nums2.length -  1){
                continue;
            }
            for(int j = pos + 1;j < nums2.length;j++){
                if(nums2[j] > nums1[i]){
                    ans[i] = nums2[j];
                    break;
                }
            }
        }
        return ans;
    }
}
