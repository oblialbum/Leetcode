package com.fengtin.LeetCode;

public class D_104 {

    public int maxDepth(TreeNode root) {
        return dfs(root);
    }
    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(dfs(root.left),dfs(root.right)) + 1;
    }
}
