package com.fengtin.LeetCode;

public class D_623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        else{
            dfs(root,val,depth);
        }
        return root;
    }

    private void dfs(TreeNode root,int val,int depth){
        if(root == null){
            return;
        }
        depth --;
        if(depth != 1){
            dfs(root.left,val,depth);
            dfs(root.right,val,depth);
        }
        else{
            TreeNode leftNode = new TreeNode(val);
            leftNode.left = root.left;
            root.left = leftNode;
            TreeNode rightNode = new TreeNode(val);
            rightNode.right = root.right;
            root.right = rightNode;
        }
    }
}
