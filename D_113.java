package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定二叉树，求路径和为固定值的路径。
 *
 * @author 王鑫
 */
public class D_113 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        dfs(root,targetSum - root.val,new ArrayList<Integer>(),ans);
        return ans;
    }

    /**
     * 节点值可能为负，不要去剪枝。
     * @param cur
     * @param targetSum
     * @param list
     * @param answer
     */
    private static void dfs(TreeNode cur,int targetSum,List list,List answer){
        list.add(cur.val);
        if(targetSum == 0){
            if(cur.left == null && cur.right == null){
                answer.add(new ArrayList<>(list));
            }
        }
        if(cur.left != null){
            dfs(cur.left,targetSum - cur.left.val,list,answer);
        }
        if(cur.right != null){
            dfs(cur.right,targetSum - cur.right.val,list,answer);
        }
        list.remove(list.size() - 1);
    }
}
