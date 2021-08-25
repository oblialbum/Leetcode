package com.fengtin.LeetCode;

public class D_129 {
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        if(root != null) {
            dfs(root, 0);
        }
        return ans;
    }

    private void dfs(TreeNode root,int sum){
        sum *= 10;
        sum += root.val;
        if(root.left == null && root.right == null){
            ans += sum;
            return;
        }
        dfs(root.left, sum);
        dfs(root.right,sum);
    }
}
