package com.fengtin.LeetCode;

/**
 * @author 王鑫
 */
public class D_124 {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(dfs(root.left),0);
        int right = Math.max(dfs(root.right),0);
        int priceNewPath = root.val + left + right;
        maxSum = Math.max(maxSum,priceNewPath);
        return root.val + Math.max(left,right);
    }
}
