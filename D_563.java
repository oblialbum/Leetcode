package com.fengtin.LeetCode;

public class D_563 {
    int res;
    public int findTilt(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        res += Math.abs(left - right);
        return left + right + root.val;
    }
}
