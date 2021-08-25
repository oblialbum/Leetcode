package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class D_102 {
    /**
     * 层序遍历二叉树
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int curSize = queue.size();
            for(int i = 0;i < curSize; i++){
                root = queue.poll();
                list.add(root.val);
                if(root.left != null){
                    queue.add(root.left);
                }
                if(root.right != null){
                    queue.add(root.right);
                }
            }
            ans.add(new ArrayList(list));
            list.clear();
        }
        return ans;
    }
}
