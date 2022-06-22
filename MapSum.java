package com.fengtin.LeetCode;

public class MapSum {
    /**
     * 字典树实现（前缀树）。
     */
     private class  Node{
         int val = 0;
         Node[] child = new Node[26];
    }
    Node root ;
    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (char c: key.toCharArray()
             ) {
            if(cur.child[c - 'a'] == null){
                cur.child[c - 'a'] = new Node();
            }
            cur = cur.child[c - 'a'];
        }
        cur.val = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (char c: prefix.toCharArray()
             ) {
            if(cur.child[c - 'a'] == null){
                return 0;
            }
            cur = cur.child[c - 'a'];
        }
        return dfs(cur);
    }

    private int dfs(Node cur) {
        if(cur == null){
            return 0;
        }
        int sum = 0;
        for (Node node:cur.child
             ) {
            sum += dfs(node);
        }
        return sum + cur.val;
    }
}
