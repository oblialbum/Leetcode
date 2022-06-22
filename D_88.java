package com.fengtin.LeetCode;

public class D_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0){
            return;
        }
        if(m == 0){
            for(int i = 0;i < n;i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        int times = 0;
        for(int i = 0,j = 0;i < m + times && j < n;){
            if(nums2[j] >= nums1[i]){
                i++;
            }
            if(nums2[j] < nums1[i]){
                insert(nums2[j],nums1,i,m+times);
                times++;
                j++;
            }
        }
        if(times < n){
            int newTimes = n - times;
            for(int i = n - 1;newTimes > 0;newTimes--,i--){
                nums1[i + m] = nums2[i];
            }
        }
        return;
    }

    private void insert(int target, int[] nums1, int pos,int length) {
        for(int i = length - 1;i >= pos;i--){
            nums1[i+1] = nums1[i];
        }
        nums1[pos] = target;
    }

    public static void main(String[] args){
        int[] nums1 = new int[]{1,3,5,8,0,0,0,0};
        int[] nums2 = new int[]{0,3,3,6};
        new D_88().merge(nums1,4,nums2,4);
    }
}
