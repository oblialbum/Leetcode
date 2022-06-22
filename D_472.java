package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class D_472 {
    Trie trie = new Trie();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (String word:words
             ) {
            if (word.length() == 0){
                continue;
            }
            if (!dfs(word,0)){
                trie.insert(word);
            }else{
                res.add(word);
            }
        }
        return res;
    }

    private boolean dfs(String word, int pos) {
        if (pos == word.length()){
            return true;
        }
        Trie.Node p = trie.root;
        for (int i = pos; i < word.length(); i++) {
            Trie.Node cur = p.child[word.charAt(i) - 'a'];
            if (cur == null){
                return false;
            }
            if (cur.isEnd){
                if (dfs(word,i + 1)) {
                    return true;
                }
            }
            p = cur;
        }
        return false;
    }

    private class Trie {
        /**
         * 前缀树。
         */
        /**
         * Initialize your data structure here.
         */
        private class Node {
            boolean isEnd;
            Node[] child = new Node[26];
        }

        Node root;

        public Trie() {
            root = new Node();
        }

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
    }

    public static void main(String[] args) {
        new D_472().findAllConcatenatedWordsInADict(new String[]{"cat","dog","catdog"});
    }
}
