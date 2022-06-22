package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class D_429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            res.add(new ArrayList<>());
            for (int i = 0; i < n; i++) {
                root = queue.poll();
                res.get(res.size() - 1).add(root.val);
                for (Node child:root.children
                     ) {
                    queue.add(child);
                }
            }
        }
        return res;
    }
}
