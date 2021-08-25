package com.fengtin.LeetCode;

import java.util.*;

public class D_501 {
    List<Integer> ans = new ArrayList<Integer>();
    public int[] findMode(TreeNode root) {
        int count = 0,maxCount = 0,base = Integer.MIN_VALUE;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val == base){
                count++;
            }
            else{
                base = root.val;
                count = 1;
            }
            if(count == maxCount){
                ans.add(root.val);
            }
            if(count > maxCount){
                ans.clear();
                maxCount = count;
                ans.add(root.val);
            }
            root = root.right;
        }
        int[] res = new int[ans.size()];
        for(int i = 0;i < ans.size();i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}
