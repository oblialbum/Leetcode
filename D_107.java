package com.fengtin.LeetCode;

import java.util.*;

public class D_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList();
        List<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i < size;i++){
                root = queue.poll();
                list.add(root.val);
                if(root.left != null){
                    queue.add(root.left);
                }
                if(root.right != null){
                    queue.add(root.right);
                }
            }
            ans.add(0,new ArrayList(list));
        }
        return ans;
    }
}
