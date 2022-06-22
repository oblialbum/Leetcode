package com.fengtin.LeetCode;

public class D_154 {
    //[111111111200011111]
    public int findMin(int[] nums) {
        int l = 0,r = nums.length - 1   ;
        while (l < r){
            int mid = l + (r - l) /2;
            if(nums[mid] >nums[r]){
                l = mid + 1;
            }
            if(nums[mid] < nums[r]){
                r = mid;
            }
            if(nums[mid] == nums[r]){
                int temp = mid;
                while(temp < r){
                    if(nums[temp] == nums[r]){
                        temp++;
                    }
                    else {
                        break;
                    }
                }
                if(temp < r){
                    /**
                     * small,big,small模式
                     */
                    l = temp;
                }
                else{
                    r = mid;
                }
            }
        }
        return nums[l];
    }
    public static void main(String[] args){
        new D_154().findMin(new int[]{3,3,1,3});
    }
}
