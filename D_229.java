package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D_229 {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int num: nums
             ) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        for (int num:map.keySet()
             ) {
            if(map.get(num) > nums.length / 3){
                ans.add(num);
            }
        }
        return ans;
    }
}
