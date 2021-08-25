package com.fengtin.LeetCode;

public class D_404 {
    int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root,0);
        return sum;
    }

    private void dfs(TreeNode root,int pos){
        if(root == null){
            return;
        }
        if(pos == -1 && root.left == null && root.right == null){
            sum += root.val;
            return;
        }
        dfs(root.left,-1);
        dfs(root.right,1);
    }
}
