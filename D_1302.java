package com.fengtin.LeetCode;

public class D_1302 {
    int maxDepth = 1;
    int ans = 0;
    public int deepestLeavesSum(TreeNode root) {
        if(root == null){
            return  0;
        }
        dfs(root,1);
        return ans;
    }

    private void dfs(TreeNode root,int depth) {
        if(root == null){
            return ;
        }
        if(maxDepth == depth){
            ans += root.val;
        }
        if(depth > maxDepth){
            maxDepth = depth;
            ans = root.val;
        }
        dfs(root.left,depth + 1);
        dfs(root.right,depth + 1);
    }
}
