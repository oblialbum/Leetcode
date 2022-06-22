package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class W_277 {
    public int countElements(int[] nums) {
        int res = 0,min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        for (int num: nums
             ) {
            if (num < min){
                min = num;
            }
            if (num > max){
                max = num;
            }
        }
        for (int num:nums
             ) {
            if (num < max  && num > min){
                res++;
            }
        }
        return res;
    }

    public int[] rearrangeArray(int[] nums) {
        int n = nums.length,big = 0,small = 0,p = 0;
        int[] res = new int[n];
        while (p < n){
            while (big < n && nums[big] <0){
                big++;
            }
            res[p++] = nums[big++];
            while (small < n && nums[small] > 0){
                small++;
            }
            res[p++] = nums[small++];
        }
        return res;
    }

    public List<Integer> findLonely(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int num:nums
             ) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        for (int num:nums
             ) {
            if (map.containsKey(num - 1) || map.containsKey(num + 1)){
                continue;
            }
            if (map.containsKey(num) && map.get(num) > 1){
                continue;
            }
            list.add(num);
        }
        return list;
    }
    public static void main(String[] args) {
        W_277 w_277 = new W_277();
    }
}
