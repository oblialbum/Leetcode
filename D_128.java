package com.fengtin.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class D_128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums
             ) {
            set.add(num);
        }
        int max = 0,cur,left,right;
        for (int num: nums
             ) {
            if(!set.contains(num)){
                continue;
            }
            cur = 1;
            right = num + 1;
            left = num - 1;
            set.remove(num);
            while (set.contains(left) || set.contains(right)){
                if(set.contains(left)){
                    set.remove(left);
                    left--;
                    cur++;
                }
                if(set.contains(right)){
                    set.remove(right);
                    right++;
                    cur++;
                }
            }
            max = Math.max(max,cur);
        }
        return max;
    }

    public static void main(String[] args) {
        new D_128().longestConsecutive(new int[]{-4,-4,2,-6,9,6,8,-6,-9,-1,9,5,2,-6,0});
    }
}
