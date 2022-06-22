package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class D_169 {
    /**
     * 快排的划分过程？三色旗问题？
     * low:[0,i)
     * mid:[i,j)
     * high:[j,nums.length - 1]
     * 不行啊，得有基准才能排序。
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if(nums.length == 1 || nums.length == 2){
            return nums[1];
        }
        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int num:nums
             ) {
            if(hashMap.containsKey(num)){
                hashMap.replace(num,hashMap.get(num) + 1);
            }
            else{
                hashMap.put(num,1);
            }
        }
        for (int num:hashMap.keySet()
             ) {
            if(hashMap.get(num) > nums.length / 2){
                return num;
            }
        }
        return -1;
    }
}
