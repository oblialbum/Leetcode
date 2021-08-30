package com.fengtin.LeetCode;

public class D_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums,0,nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int low, int high) {
        if(low > high){
            return null;
        }
        int index = max(nums,low,high);
        TreeNode root = new TreeNode(nums[index]);
        root.left = dfs(nums,low,index - 1);
        root.right = dfs(nums,index + 1,high);
        return root;
    }

    private int max(int[] nums, int low, int high) {
        int max = low;
        for(int i = low;i <= high;i++){
            if(nums[i] > nums[max]){
                max = i;
            }
        }
        return max;
    }
}
