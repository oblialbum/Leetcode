package com.fengtin.LeetCode;

public class D_513 {
    int ans, maxDepth;
    public int findBottomLeftValue(TreeNode root) {
        if(root != null) {
            dfs(root, 1);
        }
        return ans;
    }

    private void dfs(TreeNode root,int depth){
        if(root.left == null && root.right == null ){
            if(depth > maxDepth){
                ans = root.val;
                maxDepth = depth;
            }
            return;
        }
        if(root.left != null){
            dfs(root.left,depth + 1);
        }
        if(root.right != null){
            dfs(root.right,depth + 1);
        }
    }
}
