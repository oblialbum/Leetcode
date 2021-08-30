package com.fengtin.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class D_653 {
    Set<Integer> hashSet = new HashSet<Integer>();
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root,k);
    }

    private boolean dfs(TreeNode root,int sum) {
        if(root == null){
            return false;
        }
        if(dfs(root.left, sum)){
            return true;
        }
        if(dfs(root.left, sum)){
            return true;
        }
        hashSet.add(root.val);
        if(hashSet.contains(sum - root.val)){
            return true;
        }
        return false;
    }

}
