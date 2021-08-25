package com.fengtin.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class D_538 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        TreeNode p = root;
        boolean first = true;
        int sum = 0;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while (root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            if(first){
                first = false;
                sum = root.val;
            }
            else{
                root.val += sum;
                sum = root.val;
            }
            root = root.left;
        }
        return p;
    }

    private void dfs(TreeNode root){
        if(root.right != null){
            dfs(root.right);
        }
        root.val += sum;
        sum = root.val;
        if(root.left != null){
            dfs(root.left);
        }
    }
}

