package com.fengtin.LeetCode;

import java.util.*;

public class D_500 {
    boolean[] visited = new boolean[3];
    public String[] findWords(String[] words) {
        List<String> ans = new ArrayList<String>();
        String[] keyBoard = new String[]{"qwertyuiop","asdfghjkl","zxcvbnm"};
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < keyBoard.length; i++) {
            for (char c: keyBoard[i].toCharArray()
                 ) {
                map.put(c,i);
                map.put((char) (c - 32),i);
            }
        }
        for (String word: words
             ) {
            for (char c: word.toCharArray()
                 ) {
                visited[map.get(c)] = true;
            }
            int count = 0;
            if(visited[0]){
                count++;
            }
            if(visited[1]){
                count++;
            }
            if(visited[2]){
                count++;
            }
            if(count == 1){
                ans.add(word);
            }
            Arrays.fill(visited,false);
        }
        String[] arr = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }
        return arr;
    }

    public static void main(String[] args){
        System.out.println((char) ('a' - 32));
    }
}
