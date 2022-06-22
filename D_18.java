package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D_18 {
    /**
     * 回溯太麻烦，算了,循环+双指针吧。
     */
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        for(int i = 0;i < nums.length - 3;i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            //剪枝一
            if(nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target){
                break;
            }
            //剪枝二
            if(nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target){
                continue;
            }
            for(int j = i + 1;j < nums.length - 2;j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                //剪枝一
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                //剪枝二
                if (nums[i] + nums[j] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                    continue;
                }
                int diff = target - (nums[i] + nums[j]);
                for(int k = j + 1,l = nums.length - 1;k < l;){
                    if(k > j+1 && nums[k] == nums[k - 1]){
                        k++;
                        continue;
                    }
                    if(l < nums.length - 1 && nums[l] == nums[l + 1]){
                        l--;
                        continue;
                    }
                    int tempSum = nums[k] + nums[l];
                    if(tempSum > diff){
                        l--;
                        continue;
                    }
                    if(tempSum < diff){
                        k++;
                        continue;
                    }
                    if(tempSum == diff ){
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        ans.add(new ArrayList(list));
                        list.clear();
                        k++;
                        l--;
                        continue;
                    }
                }
            }
        }
        return ans;
    }


    public static void main(String[] args){
        int[] nums = new int[]{-2,-1,-1,1,1,2,2};
        new D_18().fourSum(nums,0);
    }
}
