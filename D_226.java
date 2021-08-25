package com.fengtin.LeetCode;

public class D_226 {
    public TreeNode invertTree(TreeNode root) {
        if(root != null){
            dfs(root);
        }
        return root;
    }

    private void dfs(TreeNode root){
        if(root.left == null && root.right == null){
            return;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        if(root.left != null) {
            dfs(root.left);
        }
        if(root.right != null){
            dfs(root.right);
        }
    }
}
