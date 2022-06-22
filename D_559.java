package com.fengtin.LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class D_559 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root) ;
        int ans = 0;
        while (!queue.isEmpty()){
            int cur = queue.size();
            for (int i = 0; i < cur; i++) {
                root = queue.poll();
                for (Node child: root.children
                     ) {
                    if(child != null){
                        queue.offer(child);
                    }
                }
            }
            ans++;
        }
        return ans;
    }

}
