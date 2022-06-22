package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_198 {
    int max = 0;
    int[][] memo;
    public int rob(int[] nums) {
        memo = new int [nums.length][2];
        for(int i = 0;i <nums.length;i++){
            Arrays.fill(memo[0],-1);
        }
        /**
         * DP。
         */
        memo[0][0] = 0;
        memo[0][1] = nums[0];
        for(int i = 1;i < nums.length;i++){
            memo[i][0] = Math.max(memo[i - 1][1],memo[i - 1][0]);
            memo[i][1] = memo[i - 1][0] + nums[i];
        }
        //dfs(nums,0,0,0);
        return Math.max(memo[nums.length - 1][0],memo[nums.length - 1][1]);
    }

    /**
     *
     * @param nums
     * @param pos
     * @param status:记录上一次的偷盗状态，1表示上一家刚偷完，这家不能偷。
     */
    private void dfs(int[] nums, int pos, int status,int sum) {
        if(pos == nums.length){
            max = Math.max(max,sum);
            return;
        }
        if(status == 1){
            //上次偷了，这次不偷。
            if(sum > memo[pos][0]){
                memo[pos][0] = sum;
                dfs(nums,pos+1,0,sum);
            }
        }
        else{
            //上次没偷，这次也不偷。
            if(sum > memo[pos][0]){
                memo[pos][0] = sum;
                dfs(nums,pos+1,0,sum);
            }
            //上次没偷，这次偷。
            if(sum + nums[pos] > memo[pos][1]){
                memo[pos][1] = sum + nums[pos];
                dfs(nums,pos+1,1,sum + nums[pos]);
            }
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,1};
        new D_198().rob(nums);
    }
}
