package com.fengtin.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class BSTIterator {
    TreeNode root ;
    Deque<TreeNode> stack = new LinkedList();
    public BSTIterator(TreeNode root) {
        this.root = root;
    }

    public int next() {
        int val = -1;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            val = root.val;
            root = root.right;
            return val;
        }
        return val;
    }

    public boolean hasNext() {
        return root != null || !stack.isEmpty();
    }
}
