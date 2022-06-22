package com.fengtin.LeetCode;

/**
 * @author 王鑫
 * 字典树/前缀树。
 */
public class WordDictionary {
    private class Node{
        boolean isEnd;
        Node[] child = new Node[26];
    }
    Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for (char c: word.toCharArray()
             ) {
            int index = (c - 'a');
            if(cur.child[index] == null){
                cur.child[index] = new Node();
            }
            cur = cur.child[index];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, root);
    }

    private boolean dfs(String word, Node root) {
        Node cur = root;
        for(int i = 0;i < word.length();i++){
            if(word.charAt(i) != '.'){
                if(cur.child[word.charAt(i) - 'a'] == null){
                    return false;
                }
                cur = cur.child[word.charAt(i) - 'a'];
            }
            else{
                for (Node child: cur.child
                     ) {
                    if(child != null){
                        if(dfs(word.substring(i + 1), child)){
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return cur.isEnd;
    }
}
