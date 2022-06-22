package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class D_337 {
    Map<TreeNode,Integer> choose;
    Map<TreeNode,Integer> dontChoose;
    public int rob(TreeNode root) {
        choose = new HashMap<>();
        dontChoose = new HashMap<>();
        dfs(root);
        return Math.max(choose.getOrDefault(root,0),dontChoose.getOrDefault(root,0));
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        dfs(root.left);
        dfs(root.right);
        choose.put(root,root.val + dontChoose.getOrDefault(root.left,0) + dontChoose.getOrDefault(root.right,0));
        dontChoose.put(root,Math.max(choose.getOrDefault(root.left,0),dontChoose.getOrDefault(root.left,0)) + Math.max(choose.getOrDefault(root.right,0),dontChoose.getOrDefault(root.right,0)));
    }
}
