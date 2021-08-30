package com.fengtin.LeetCode;

import java.util.*;

public class W_256 {
    int min = Integer.MAX_VALUE;

    /**
     * 仅包含一二题，下面不会了。
     * @param nums
     * @param k
     * @return
     */
    public int minimumDifference(int[] nums, int k) {
        if(k == 1){
            return 0;
        }
        Arrays.sort(nums);
        for(int i = 0;i + k <= nums.length;i++){
            min = Math.min(min,nums[i+k-1] - nums[i]);
        }
        return min;
    }

    public String kthLargestNumber(String[] nums, int k) {
        if(k > nums.length){
            return null;
        }
        /**
         * 默认是最小堆
         */
        Queue<String> heap = new PriorityQueue<String>(k,new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                if(s1.length() > s2.length()){
                    return -1;
                }
                if(s1.length() < s2.length()){
                    return 1;
                }
                for(int i = 0;i < s1.length(); i++){
                    if(s1.charAt(i) > s2.charAt(i)){
                        return -1;
                    }
                    if(s1.charAt(i) < s2.charAt(i)){
                        return 1;
                    }
                }
                return 1;
            }
        });
        for(int i = 0;i < nums.length;i++){
            heap.offer(nums[i]);
        }
        for(int i = 0;i < k - 1;i++){
            heap.poll();
        }
        return heap.peek();
    }

}
