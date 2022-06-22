package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class D_947 {
    public int subarraysDivByK(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        Map<Integer,Integer> map = new HashMap<>();
        prefixSum[0] = nums[0];
        map.put(nums[0] % k,1);
        int ans = 0;
        for(int i = 1;i < nums.length;i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i];
            map.put(prefixSum[i] % k,map.getOrDefault(prefixSum[i] % k,0) + 1);
        }
        for (int mod:map.keySet()
             ) {
            if (mod == 0) {
                ans += map.get(mod) * (map.get(mod) + 1) / 2;
            } else {
                ans += map.get(mod) * (map.get(mod) - 1) / 2;
                if(mod > 0){
                    ans += map.get(mod) * map.getOrDefault(mod - k,0);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args){
        new D_947().subarraysDivByK(new int[]{8,-5,-4},6);
    }
}
