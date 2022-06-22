package com.fengtin.LeetCode;

public class D_993 {
    int depth1,depth2;
    TreeNode xParent,yParent;
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode pre = null;
        dfs(root, x,y,0,pre);
        if(depth1 != depth2){
            return false;
        }
        else if(xParent == yParent){
            return false;
        }
        return true;
    }

    private void dfs(TreeNode root, int x, int y, int depth, TreeNode pre) {
        if(root == null){
            return;
        }
        if(root.val == x){
            xParent = pre;
            depth1 = depth;
        }
        if(root.val == y){
            yParent = pre;
            depth2 = depth;
        }
        if(depth1 != 0 && depth2 != 0){
            return;
        }
        dfs(root.left,x,y,depth + 1,root);
        dfs(root.right,x,y,depth + 1,root);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        new D_993().isCousins(root,2,3);
    }
}
