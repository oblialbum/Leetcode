package com.fengtin.LeetCode;

import java.util.*;

public class W_262 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> ans = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int num :nums1
             ) {
            set.add(num);
        }
        for (int num:nums2
             ) {
            if(set.contains(num)){
                ans.add(num);
            }
        }
        for (int num:nums3
        ) {
            if(set.contains(num)){
                ans.add(num);
            }
        }
        set.clear();
        for (int num:nums2
        ) {
            set.add(num);
        }
        for (int num:nums3
        ) {
            if(set.contains(num)){
                ans.add(num);
            }
        }
        for (int num: ans
             ) {
            res.add(num);
        }
        return res;
    }
    public int minOperations(int[][] grid, int x) {
        int[] nums = new int[grid.length * grid[0].length];
        int p = 0;
        for(int i =0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                nums[p++] = grid[i][j];
            }
        }
        Arrays.sort(nums);
        for(int i = 0;i < nums.length - 1;i++){
            if(nums[i] == nums[i + 1]){
                continue;
            }
            if((nums[i + 1] - nums[i]) % x != 0 ){
                return  -1;
            }
        }
        int sum = 0;
        for (int num: nums
             ) {
            sum += Math.abs(nums[nums.length / 2] - num) / x;
        }
        return sum;
    }

    public static void main(String[] args){
        new W_262().minOperations(new int[][]{{2,4},{6,8}},2);
    }
}
