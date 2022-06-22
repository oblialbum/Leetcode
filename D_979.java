package com.fengtin.LeetCode;

public class D_979 {
    int res = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null){
            return 0;
        }
        int L = dfs(root.left);
        int R = dfs(root.right);
        res += Math.abs(L) + Math.abs(R);
        return root.val - 1 + L + R;
    }
}
