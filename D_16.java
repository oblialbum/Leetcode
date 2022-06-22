package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff2 = Integer.MAX_VALUE,diff,symbol = 1 ,sum = 0;
        for(int i = 0;i < nums.length - 2;i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            diff = target - nums[i];
            for(int j = i+1,k = nums.length - 1; j < k;){
                if(j > i + 1 && nums[j] == nums[j -1]){
                    j++;
                    continue;
                }
                if(k < nums.length - 1 && nums[k] == nums[k+1]){
                    k--;
                    continue;
                }
                sum = nums[k] + nums[j];
                if(diff2 > Math.abs(sum - diff)){
                    diff2 = Math.abs(sum - diff);
                    if(sum > diff){
                        symbol = 1;
                    }
                    else{
                        symbol = -1;
                    }
                }
                if(sum > diff){
                    k--;
                    continue;
                }
                if(sum < diff){
                    j++;
                    continue;
                }
                return target;
            }
        }
        return diff2 * symbol + target;
    }
    public  static void main(String[] args){
        int[] nums = new int[]{-1,2,1,-4};
        new D_16().threeSumClosest(nums,1);
    }
}
