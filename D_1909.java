package com.fengtin.LeetCode;

public class D_1909 {
    public boolean canBeIncreasing(int[] nums) {
        for(int i = 0;i < nums.length - 1;i++){
            if(nums[i] >= nums[i + 1]){
                return check(nums,i) || check(nums,i + 1);
            }
        }
        return true;
    }

    private boolean check(int[] nums,int pos) {
        /**
         * 不检查pos元素。
         */
        int begin = 0,end = nums.length - 1;
        if(pos == begin || pos == end) {
            if (pos == 0) {
                begin++;
            }
            if (pos == end) {
                end--;
            }
            for (int i = begin; i < end; i++) {
                if (nums[i] >= nums[i + 1]) {
                    return false;
                }
            }
            return true;
        }
        else{
            for(int i = 0;i < nums.length - 1;i++){
                if(i == pos - 1){
                    if(nums[i] >= nums[i +2]){
                        return false;
                    }
                    i++;
                }
                else {
                    if (nums[i] >= nums[i + 1]) {
                        return false;
                    }
                }
            }

            return true;
        }
    }

    public static void main(String[] args){
        new D_1909().canBeIncreasing(new int[]{1,1,1});
    }
}
