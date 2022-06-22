package com.fengtin.LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class I_04_06 {
    TreeNode res ;
    boolean flag ;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null){
            while (root.left != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (flag){
                res = root;
                return res;
            }
            if (root == p){
                flag = true;
            }
            root = root.right;
        }
        return res;
    }


}
