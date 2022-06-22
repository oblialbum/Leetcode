package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class D_560 {
    public int subarraySum(int[] nums, int k) {
        if(nums.length == 1){
            return nums[0] == k ? 1: 0;
        }
        int[] sum = new int[nums.length];
        int ans = 0;
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int prefixSum:sum
             ) {
            if(map.containsKey(prefixSum - k)){
                ans += map.get(prefixSum - k);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0) + 1);
        }
        return ans ;
    }

    public static void main(String[] args) {
        new D_560().subarraySum(new int[]{-2,-3,-4,-1,-5},-5);
    }
}
