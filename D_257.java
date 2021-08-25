package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_257 {
    List<String> ans = new ArrayList<>();
    StringBuffer sb = new StringBuffer();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root != null) {
            sb.append(""+root.val);
            dfs(root,sb.length());
        }
        return ans;
    }

    private void dfs(TreeNode root,int index){
        if(root.left != null){
            sb.append("->"+root.left.val);
            dfs(root.left,sb.length());
            sb.delete(index,sb.length());
        }
        if(root.right != null){
            sb.append("->"+root.right.val);
            dfs(root.right,sb.length());
            sb.delete(index,sb.length());
        }
        if(root.left == null && root.right == null){
            ans.add(sb.toString());
            return;
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(52222);
        new D_257().binaryTreePaths(root);
    }
}
