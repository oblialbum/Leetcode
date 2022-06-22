package com.fengtin.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class D_870 {
    /**
     * 尽可能选择比当前Nums2[i]小的数字去匹配。
     * 如果nums1的当前数字比nums2的小，则去匹配最大的。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int n = nums1.length,left = 0,right = nums1.length - 1;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for(int i = 0;i < n;i++){
            maxHeap.add(new int[]{nums2[i],i});
        }
        int[] ans = new int[n];
        while (!maxHeap.isEmpty()){
            int[] temp = maxHeap.poll();
            if(temp[0] < nums1[right]){
                ans[temp[1]] = nums1[right--];
            }
            else{
                ans[temp[1]] = nums1[left++];
            }
        }
        return ans;
    }
}
