package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D_350 {
    /**
     * 进阶：
     * 1.数组有序：无需用hash表进行去重，定义俩个指针遍历俩个数组。
     * 2.nums1比nums2小的多：优化后的方法更好。
     * 3.nums2存储再磁盘上：用本方法。优化方法无法排序。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int nums: nums1
             ) {
            if(!map.containsKey(nums)){
                map.put(nums,1);
            }
            else{
                map.replace(nums,map.get(nums) + 1);
            }
        }
        for (int nums: nums2
             ) {
            if(map.containsKey(nums) && map.get(nums) != 0){
                list.add(nums);
                map.replace(nums,map.get(nums) - 1);
            }
        }
        int[] ans = new int[list.size()];
        for(int i = 0;i < ans.length;i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
