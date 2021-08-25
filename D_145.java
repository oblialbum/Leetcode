package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class D_145 {
    List<Integer> ans = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root != null){
            Deque<TreeNode> stack = new LinkedList();
            TreeNode prev = null;
            while(root != null || !stack.isEmpty()){
                while(root != null){
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if(root.right == null || root.right == prev){
                    ans.add(root.val);
                    prev = root;
                    root = null;
                }
                else{
                    stack.push(root);
                    root = root.right;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        new D_145().postorderTraversal(root);
    }
}
