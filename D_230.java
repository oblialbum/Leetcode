package com.fengtin.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class D_230 {
    int val = -1;
    public int kthSmallest(TreeNode root, int k) {
        if(root != null){
            Deque<TreeNode> stack = new LinkedList();
            while (root != null || !stack.isEmpty()){
                while(root != null){
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                k--;
                if(k == 0){
                    val = root.val;
                    break;
                }
                root = root.left;
            }
        }
        return val;
    }
}
