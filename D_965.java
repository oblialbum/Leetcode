package com.fengtin.LeetCode;

public class D_965 {
    int num;
    public boolean isUnivalTree(TreeNode root) {
        num = root.val;
        return dfs(root);
    }

    private boolean dfs(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.val != num){
            return false;
        }
        return dfs(root.left) && dfs(root.right);
    }
}
