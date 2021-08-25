package com.fengtin.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class D_111 {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.offer(root);
        int depth = 1;
        boolean flag = false;
        while(!stack.isEmpty()){
            int curSize = stack.size();
            for(int i = 0;i < curSize; i++){
                root = stack.remove();
                if(root.left != null){
                    stack.offer(root.left);
                }
                if(root.right != null){
                    stack.offer(root.right);
                }
                if(root.left == null && root.right == null){
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
            depth++;
        }
        return depth;
    }
}
