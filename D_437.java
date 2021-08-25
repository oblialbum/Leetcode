package com.fengtin.LeetCode;

public class D_437 {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        return dfs(root, targetSum) + pathSum(root.left,targetSum) + pathSum(root.right,targetSum);
    }

    private int dfs(TreeNode root,int targetSum){
        if(root == null){
            return 0;
        }
        targetSum -= root.val;
        int result = targetSum == 0 ? 1 : 0;
        return result + dfs(root.left,targetSum) + dfs(root.right,targetSum);
    }
    public static void main(String[] args) {
        int a = 1;
        System.out.println(a+","+ (a == 1? 1 : 0));
    }
}
