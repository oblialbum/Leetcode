package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class D_199 {
    /**
     * 右视图，层序遍历取每层最后一个节点。
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int curSize = queue.size();
            for(int i = 0;i < curSize;i++){
                root = queue.poll();
                if(root.left != null){
                    queue.add(root.left);
                }
                if(root.right != null){
                    queue.add(root.right);
                }
                if(i == curSize - 1){
                    ans.add(root.val);
                }
            }
        }
        return ans;
    }
}
