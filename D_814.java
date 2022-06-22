package com.fengtin.LeetCode;

public class D_814 {
    public TreeNode pruneTree(TreeNode root) {
        return dfs(root) ? null : root;
    }

    /**
     * 一棵树的左子树，右子树，本身都为0时才移除。
     * @param root
     * @return
     */
    private boolean dfs(TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean flag1 = dfs(root.left),flag2 = dfs(root.right);
        if (flag1){
            root.left = null;
        }
        if (flag2){
            root.right = null;
        }
        return flag1 && flag2 && root.val == 0;
    }
}
