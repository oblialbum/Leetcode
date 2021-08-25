package com.fengtin.LeetCode;

import java.util.*;

/**
 * hard，通过50%，wordList很长时，复杂度太高，无法得到结果。
 * 太难了
 * @author 王鑫
 */
public class D_127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if(wordSet.size() == 0 || !wordSet.contains(endWord)){
            return 0;
        }
        int step = 1;
        wordSet.remove(beginWord);
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while(!queue.isEmpty()){
            int currentSize = queue.size();
            for(int i = 0;i < currentSize;i++){
                String currentWord = queue.poll();
                if(oneDifferentChar(currentWord,endWord,queue,visited,wordSet)){
                    return step + 1;
                }
            }
            step ++;
        }
        return 0;
    }
    private  boolean oneDifferentChar(String currentWord,String endWord,Queue<String> queue,HashSet<String> visited,HashSet<String> wordSet){
        char[] arr = currentWord.toCharArray();
        for(int i = 0;i < arr.length;i++){
            char originalChar = arr[i];
            for(char ch = 'a';ch <= 'z';ch++){
                if(ch == originalChar){
                    continue;
                }
                arr[i] = ch;
                String nextWord = new String(arr);
                if(wordSet.contains(nextWord)){
                    if(nextWord.equals(endWord)){
                        return true;
                    }
                    if(!visited.contains(nextWord)){
                        queue.add(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            arr[i] = originalChar;
        }
        return false;
    }

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        String[] s = new String[]{"hot","dot","dog","lot","log","cog"};
        for(int i = 0;i < s.length;i++){
            list.add(s[i]);
        }
        System.out.println(new D_127().ladderLength("hit","cog",list));
    }
}
