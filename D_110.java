package com.fengtin.LeetCode;

public class D_110 {
    /**
     * 判断是否是平衡二叉树。
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    /**
     * -1代表非平衡，否则返回正常树的高度。
     * @param root
     * @return
     */
    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = dfs(root.left);
        if(l == -1){
            return -1;
        }
        int r = dfs(root.right);
        if(r == -1){
            return -1;
        }
        if(Math.abs(l - r) > 1){
            return -1;
        }
        return Math.max(l,r) + 1;
    }
}
