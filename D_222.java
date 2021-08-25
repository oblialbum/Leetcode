package com.fengtin.LeetCode;

public class D_222 {
    /**
     * hight:树的高度.
     * left:指向每层的第一个节点，直到倒数第二层。
     */
    int hight;
    TreeNode left;
    int ans;
    public int countNodes(TreeNode root) {
        if(root != null){
            left = root;
            while(left != null){
                hight++;
                left = left.left;
            }
            ans = (int)Math.pow(2,hight) - 1;
            dfs(root,1);
        }
        return ans;
    }

    private boolean dfs(TreeNode root,int pos){
        if(pos < hight){
            if(dfs(root.right,pos + 1)){
                return true;
            }
            if(dfs(root.left,pos + 1)){
                return true;
            }
        }
        if(pos == hight){
            if(root == null){
               ans--;
               return false;
            }
        }
        return false;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        new D_222().countNodes(root);
    }
}
