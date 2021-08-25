package com.fengtin.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class D_530 {
    int ans = Integer.MAX_VALUE,pre = -1;
    public int getMinimumDifference(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while (root != null || !stack.isEmpty()){
            while (root != null ){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre == -1){
                pre = root.val;
            }
            else{
                ans = Math.min(ans,root.val - pre);
                pre = root.val;
            }
            root = root.right;
        }
        return ans;
    }
}
