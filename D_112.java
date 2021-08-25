package com.fengtin.LeetCode;

public class D_112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        return dfs(root,targetSum);
    }
    private boolean dfs(TreeNode root, int sum){
        if(root.left == null && root.right == null){
            return sum == root.val;
        }
        int newSum = sum - root.val;
        if(root.left != null){

                if(dfs(root.left,newSum)){
                    return true;
                }


        }
        if(root.right != null){

                if(dfs(root.right,newSum)){
                    return true;
                }

        }
        return false;
    }
}
