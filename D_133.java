package com.fengtin.LeetCode;

import java.util.*;

public class D_133 {

    public Node cloneGraph(Node node) {
        Set<Integer> set = new HashSet<>();
        Node ans = new Node(node.val, (ArrayList<Node>) node.neighbors),newNode;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(ans);
        set.add(ans.val);
        Node root;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.remove();
                for (int j = 0; j < root.neighbors.size(); j++) {
                    if(set.add(root.neighbors.get(j).val)){
                        newNode = new Node(root.neighbors.get(j).val, (ArrayList<Node>) root.neighbors.get(j).neighbors);
                        root.neighbors.remove(j);
                        System.out.println(root.neighbors.get(j) == newNode);
                        root.neighbors.add(j,newNode);
                        queue.offer(root.neighbors.get(j));
                    }
                }
            }
        }
        return ans;
    }
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        /**
         * 尽管neighbor是同一个引用，但是是不同的node.
         * @param _val
         * @param _neighbors
         */
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
