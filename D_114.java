package com.fengtin.LeetCode;

public class D_114 {
    /**
     * 按照前序遍历的顺序将二叉树转化为链表，左节点为空。\
     * 不能新建链表，然后赋值给root。
     * root自身无法改变，可以改变root.right。
     * @param root
     */
    TreeNode curNode;

    public void flatten(TreeNode root) {
        curNode = new TreeNode(0);
        dfs(root);

    }

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        curNode = curNode.right = root;
        dfs(left);
        dfs(right);
    }
}
