package com.fengtin.LeetCode;

public class D_100 {
    /**
     * 前序+中序可以唯一的确定一颗二叉树，可以考虑这样来判断俩颗树是否相同。O(n),O(n)。
     *递归，每次判断当前节点数树是否符合规则。
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        /**
         * 下面俩个if条件，确定了p,q一定是均不为null的节点。
         */
        if(p == null && q ==null){
            return true;
        }
        if((p == null && q != null) || (q == null && p != null)){
            return false;
        }

        if(p.val != q.val){
            return false;
        }
        return dfs(p.left, q.left) && dfs(p.right,q.right);

    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
