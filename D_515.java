package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class D_515 {
    List<Integer> ans = new ArrayList<Integer>();
    public List<Integer> largestValues(TreeNode root) {
        if(root != null) {
            int max;
            Queue<TreeNode> queue = new LinkedList();
            queue.add(root);
            while(!queue.isEmpty()){
                int curSize = queue.size();
                max = Integer.MIN_VALUE;
                for(int i = 0;i < curSize;i++){
                    TreeNode node = queue.poll();
                    if(node.left != null) {
                        queue.offer(node.left);
                    }
                    if(node.right != null) {
                        queue.offer(node.right);
                    }
                    int num = node.val;
                    max = Math.max(max,num);
                }
                ans.add(max);
            }
        }
        return ans;
    }
}
