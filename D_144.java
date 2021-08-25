package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class D_144 {
    List<Integer> ans = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root != null) {
            Deque<TreeNode> stack = new LinkedList<TreeNode>();
            while (root != null || !stack.isEmpty()){
                while(root != null){
                    stack.push(root);
                    ans.add(root.val);
                    root = root.left;
                }
                root = stack.pop();
                root = root.right;
            }
        }
        return ans;
    }
}
