package com.fengtin.LeetCode;

import java.util.*;

public class D_1123 {
    //BFS找最深节点+建立parentMap。最深节点挨个遍历获取parent,出现相同的parent(由于深度相同，同时出现)时结束。
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        queue.offer(root);
        int curSize;
        boolean maxDepth ;
        List<TreeNode> list = new ArrayList<>();
        while (!queue.isEmpty()){
            curSize = queue.size();
            maxDepth = true;
            for (int i = 0; i < curSize; i++) {
                root = queue.poll();
                list.add(root);
                if (root.left != null){
                    queue.offer(root.left);
                    parent.put(root.left,root);
                    maxDepth = false;
                }
                if (root.right != null){
                    queue.offer(root.right);
                    parent.put(root.right,root);
                    maxDepth = false;
                }
            }
            if (maxDepth){
                break;
            }
            list.clear();
        }
        if (queue.size() == 1){
            return queue.poll();
        }
        Set<TreeNode> path = new HashSet<>();
        while (list.size() != 1){
            for (TreeNode cur:list
                 ) {
                path.add(parent.get(cur));
            }
            list.clear();
            list.addAll(path);
            path.clear();
        }
        return list.get(0);
    }
}
