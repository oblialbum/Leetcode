package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class D_236 {
    Set<Integer> visited = new HashSet();
    Map<Integer,TreeNode> parent = new HashMap<Integer,TreeNode>();
    private void dfs(TreeNode root) {
        if(root.left != null){
            parent.put(root.left.val,root);
            dfs(root.left);
        }
        if(root.right != null){
            parent.put(root.right.val,root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while(p != null){
            visited.add(p.val);
            // 最后P = root时，再从map取父节点时，返回null。
            p = parent.get(p.val);
        }
        while(q != null){
            if(visited.contains(q.val)){
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }
}
