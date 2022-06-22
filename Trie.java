package com.fengtin.LeetCode;

public class Trie {
    /**
     * 前缀树。
     */
    /** Initialize your data structure here. */
    private class Node{
        boolean isEnd ;
        Node[] child = new Node[26];
    }
    Node root ;
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node p = root;
        for (char c: word.toCharArray()
             ) {
            if(p.child[c - 'a'] == null){
                p.child[c - 'a'] = new Node();
            }
            p = p.child[c - 'a'];
        }
        p.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node p = root;
        for (char c: word.toCharArray()
             ) {
            if(p.child[c - 'a'] == null){
                return false;
            }
            p = p.child[c - 'a'];
        }
        return p.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix.
     *  Include prefix.
     * */
    public boolean startsWith(String prefix) {
        Node p = root;
        for (char c: prefix.toCharArray()
        ) {
            if(p.child[c - 'a'] == null){
                return false;
            }
            p = p.child[c - 'a'];
        }
        return true;
    }
}
