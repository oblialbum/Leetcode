package com.fengtin.LeetCode;

import java.util.ArrayList;

public class W_263 {
    public boolean areNumbersAscending(String s) {
        String[] array = s.split(" ");
        int begin = -101,cur ;
        for(int i = 0;i < array.length;i++){
            if(array[i].charAt(0) >= '0' && array[i].charAt(0) <= '9'){
                cur = Integer.parseInt(array[i]);
                if(cur <= begin){
                    return false;
                }
                begin = cur;
            }
        }
        return true;
    }

    int ans = 0;
    public int countMaxOrSubsets(int[] nums) {
        int max = nums[0],cur = nums[0];
        for(int i = 1;i <nums.length;i++){
            if((cur | nums[i]) > max){
                max = cur | nums[i] ;
            }
            cur = cur | nums[i];
        }
        dfs(nums,0,max,new ArrayList<Integer>());
        return ans;
    }

    private void dfs(int[] nums, int pos,int target,ArrayList<Integer> list) {
        if(pos == nums.length){
            if(list.size() > 0) {
                ans += calculate(nums, list) == target ? 1 : 0;
            }
            return;
        }
        dfs(nums,pos + 1,target,list);
        list.add(pos);
        dfs(nums,pos + 1,target,list);
        list.remove(list.size() - 1);
    }
    
    private int calculate(int[] nums,ArrayList<Integer> list){
        int max = nums[list.get(0)],cur = nums[list.get(0)];
        for(int i = 1;i < list.size();i++){
            if((cur | nums[list.get(i)]) > max){
                max = cur | nums[list.get(i)] ;
            }
            cur = cur | nums[list.get(i)];
        }
        return max;
    }
    public static void main(String[] args){
        System.out.println(0|10);
    }
}
