package com.fengtin.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class D_414 {
    public int thirdMax(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return nums[0] > nums[1] ? nums[0]: nums[1];
        }
        Set<Integer> set = new HashSet<>();
        int p = 0;
        while(set.size() < 3 && p < nums.length){
            set.add(nums[p++]);
        }
        if(set.size() < 3){
            int max = Integer.MIN_VALUE;
            for (int num: set
                 ) {
                max = Math.max(max,num);
            }
            return max;
        }
        while(p < nums.length){
            int val = nums[p++],i = 0;
            int[] arr = new int[3];
            for (int num: set
                 ) {
                arr[i++] = num;
            }
            if(arr[0] < arr[1]){
                swap(arr,0,1);
            }
            if(arr[0] < arr[2]){
                swap(arr,0,2);
            }
            if(arr[1] < arr[2]){
                swap(arr,1,2);
            }
            for(int j = 0; j < 3;j++){
                if(val == arr[j]){
                    break;
                }
                if(val > arr[j]){
                    set.remove(arr[2]);
                    for(int k = 2;k > j;k--){
                        arr[k] = arr[k - 1];
                    }
                    arr[j] = val;
                    set.add(val);
                    break;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int num: set
        ) {
            min = Math.min(min,num);
        }
        return min;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args){
        new D_414().thirdMax(new int[]{23,435,213245,5647,2345,344,3345,2345,2345,12345,2345,123456,123456,2345,2345,12345,23456,23456,123456,123456,123456,12345,12345});
    }
}
