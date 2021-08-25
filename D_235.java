package com.fengtin.LeetCode;

public class D_235 {
    TreeNode scan ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        scan = root;
        dfs(scan,p.val,q.val);
        return scan;
    }

    private void dfs(TreeNode root,int val1,int val2){
        if(root.val > val1 && root.val > val2){
            dfs(root.left,val1,val2);
        }
        if(root.val < val1 && root.val < val2){
            dfs(root.right,val1,val2);
        }
        scan = root;
        return;
    }
}
