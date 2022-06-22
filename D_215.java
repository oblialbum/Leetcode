package com.fengtin.LeetCode;

import java.util.Random;

/**
 * @author 王鑫
 */
public class D_215 {
    int K ;
    Random random;
    public int findKthLargest(int[] nums, int k) {
        K = nums.length - k;
        random = new Random();
        return seleceKth(nums,0,nums.length - 1);
    }


    public int seleceKth(int[] nums,int left,int right){
        if (right == left){
            return nums[left];
        }
        int temp = random.nextInt(right - left + 1) +left;
        swap(nums,temp,left);
        int pivot = nums[left],low = left + 1,hi = right;
        while(low <= hi){
            while (low <= hi && nums[low] < pivot){low++;}
            while (hi >= low && nums[hi] > pivot){hi--;}
            if (low < hi){
                swap(nums,low,hi);
                low++;
                hi--;
            }else{
                break;
            }
        }
        swap(nums,left,hi);
        if (hi == K){
            return nums[K];
        }else if (hi > K){
            return seleceKth(nums,left,hi - 1);
        }else{
            return seleceKth(nums,hi + 1,right);
        }
    }

    public void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        new D_215().findKthLargest(new int[]{3,2,1,5,6,4},2);
    }
}
