package com.fengtin.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class D_1609 {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean odd = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            int min = -(int)Math.pow(10,6) - 1;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                int curVal = cur.val;
                if (odd){
                    if (curVal % 2 == 1){
                        return false;
                    }
                    curVal *= -1;
                }else{
                    if (curVal % 2 == 0){
                        return false;
                    }
                }
                if (curVal <= min){
                    return false;
                }else{
                    min = curVal;
                }
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
            }
            odd = !odd;
        }
        return true;
    }
}
