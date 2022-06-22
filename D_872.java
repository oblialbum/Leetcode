package com.fengtin.LeetCode;

public class D_872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuffer sb1 = new StringBuffer(),sb2 = new StringBuffer();
        dfs(root1,sb1);
        dfs(root2,sb2);
        return sb1.toString().equals(sb2.toString());
    }

    private void dfs(TreeNode root, StringBuffer sb) {
        if(root.left == null && root.right == null){
            sb.append(root.val + ",");
            return;
        }
        if(root.left != null){
            dfs(root.left,sb);
        }
        if(root.right != null){
            dfs(root.right,sb);
        }
    }
}
