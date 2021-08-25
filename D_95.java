package com.fengtin.LeetCode;

import java.util.LinkedList;
import java.util.List;

public class D_95 {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1,n);
    }

    private List<TreeNode> generateTrees(int begin,int end){
        List<TreeNode> allTrees = new LinkedList<>();
        if(begin > end){
            allTrees.add(null);
            return allTrees;
        }
        for(int i = begin ;i <= end;i++){
            List<TreeNode> leftTrees = generateTrees(begin,i-1);
            List<TreeNode> rightTrees = generateTrees(i+1,end);

            for(TreeNode left: leftTrees){
                for(TreeNode right:rightTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;
    }
}
