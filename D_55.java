package com.fengtin.LeetCode;

public class D_55 {

    public boolean canJump(int[] nums) {
        visited = new boolean[nums.length];
        visited[0] = true;
        return dfs(nums,0);
    }



    boolean[] visited ;
    private boolean dfs(int[] nums, int pos) {
        if(pos == nums.length - 1){
            return true;
        }
        /**
         * 剪枝一：从当前能达到的最大位置开始访问。
         */
        for(int i = Math.min(nums.length-1,pos + nums[pos]);i > pos;i--){
            /**
             * 剪枝二：访问过的位置无法再访问。
             */
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            if(dfs(nums,i)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[]matrix = new int[]{2,0};
        System.out.println(new D_55().canJump(matrix));
    }
}
