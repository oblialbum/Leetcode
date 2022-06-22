package com.fengtin.LeetCode;

public class D_617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }
        dfs(null,root1,root2,-1);
        return root1;
    }

    private void dfs(TreeNode pre, TreeNode root1, TreeNode root2,int pos) {
        if(root1 == null && root2 == null){
            return ;
        }
        if(root1 != null && root2 != null){
            root1.val += root2.val;
            dfs(root1,root1.left,root2.left,0);
            dfs(root1,root1.right,root2.right,1);
        }
        if(root1 != null && root2 == null){
            dfs(root1,root1.left,null,0);
            dfs(root1,root1.right,null,1);
        }
        if(root1 == null && root2 != null){
            if(pos == 0){
                pre.left = new TreeNode(root2.val);
                root1 = pre.left;
            }
            else{
                pre.right = new TreeNode(root2.val);
                root1 = pre.right;
            }
            dfs(root1,null,root2.left,0);
            dfs(root1,null,root2.right,1);
        }
    }
    public static void main(String[] args){
        TreeNode p = new TreeNode(1),q;
        q = p.left;
        p.left = new TreeNode(2);
        q = p.left;
        System.out.println(1);
    }
}
