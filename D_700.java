package com.fengtin.LeetCode;

public class D_700 {
    TreeNode ans = null;
    public TreeNode searchBST(TreeNode root, int val) {
        dfs(root,val);
        return ans;
    }

    private boolean dfs(TreeNode root, int val) {
        if(root == null){
            return true;
        }
        if(root.val == val){
            ans = root;
            return true;
        }
        if(root.val > val){
            if(dfs(root.left, val)){
                return true;
            }
        }
        if(root.val < val){
            if(dfs(root.right, val)){
                return true;
            }
        }
        return false;
    }
}
