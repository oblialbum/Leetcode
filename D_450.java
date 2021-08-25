package com.fengtin.LeetCode;

public class D_450 {
    /**
     * 返回值无需判断，leetcode判断删除之后的树是否满足要求。
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key < root.val){
            root.left = deleteNode(root.left,key);
        }
        else if(key > root.val){
            root.right = deleteNode(root.right,key);
        }
        else{
            if(root.left == null && root.right == null){
                root = null;
            }
            else if(root.right != null){
                root.val = rightMin(root);
                root.right = deleteNode(root.right,root.val);
            }
            else{
                root.val = leftMax(root);
                root.left = deleteNode(root.left,root.val);
            }
        }
        return root;
    }

    private int rightMin(TreeNode root) {
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root.val;
    }

    private int leftMax(TreeNode root) {
        root = root.left;
        while(root.right != null){
            root = root.right;
        }
        return root.val;
    }
}
