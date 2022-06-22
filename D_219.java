package com.fengtin.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class D_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        if(nums.length <= k){
            for(int i = 0;i < nums.length;i++){
                if(set.contains(nums[i])){
                    return true;
                }
                else{
                    set.add(nums[i]);
                }
            }
        }
        int slow = 0, fast = k;
        for(int i = slow;i <= fast; i++){
            if(set.contains(nums[i])){
                return true;
            }
            else{
                set.add(nums[i]);
            }
        }
        while(fast < nums.length - 1 ){
            set.remove(nums[slow]);
            fast++;
            slow++;
            if(set.contains(nums[fast])){
                return true;
            }
            else{
                set.add(nums[fast]);
            }
        }
        return false;
    }
}
