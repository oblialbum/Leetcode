package com.fengtin.LeetCode;

import java.util.*;

public class D_126 {
    /**
     * pos用来存储字符串和对应的下标，可能beginword不在pos中，需要进行判断。
     * times记录记录每个字符串对应的最少访问次数。
     */
    List<List<String>> ans = new ArrayList<>();
    List<String> list = new ArrayList<>();
    int[] times;
    int minStep = Integer.MAX_VALUE;
    Map<String, Integer> pos = new HashMap<>();

    /**
     * 需要先找到最小steps，否则dfs时间太长了，且主要花在找第一个解上。
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return ans;
        }
        bfs(beginWord, endWord, wordList);
        for (int i = 0; i < wordList.size(); i++) {
            pos.put(wordList.get(i), i);
        }
        times = new int[wordList.size()];
        list.add(beginWord);
        Arrays.fill(times, -1);
        long begin = System.currentTimeMillis();

        dfs(beginWord, endWord, wordList, 1);

        long end = System.currentTimeMillis();
        end -= begin;
        return ans;
    }

    /**
     * BFS寻找最短的路径，返回最短路径长度。
     *
     * 主要时间花在DFS上，应该可以进一步优化。
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     */
    Map<String, Integer> steps;
    private void bfs(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word : wordList
        ) {
            dict.add(word);
        }
        dict.remove(beginWord);
        steps = new HashMap<>();
        steps.put(beginWord, 0);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 1;
        boolean found = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                char[] ch = curWord.toCharArray();
                for (int j = 0; j < ch.length; j++) {
                    char original = ch[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != original) {
                            ch[j] = c;
                            String newWord = String.valueOf(ch);
                            if (!dict.contains(newWord)) {
                                continue;
                            }
                            dict.remove(newWord);
                            queue.offer(newWord);
                            steps.put(newWord, step);
                            if (newWord.equals(endWord)) {
                                found = true;
                            }

                        }
                    }
                    ch[j] = original;
                }
            }
            step++;
            if (found) {
                break;
            }
        }
        if(found){
            minStep = step - 1;
        }
    }

    /**
     * 进一步优化：在BFS中建立一个Map<String,List<String>>,记录String的nextWord信息，在DFS递归的过程中，只迭代当前单词的Map。
     * @param beginWord
     * @param endWord
     * @param wordList
     * @param step
     */
    private void dfs(String beginWord, String endWord, List<String> wordList, int step) {
        if(step == minStep + 1){
            if(beginWord.equals(endWord)) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i = 0 ;i < wordList.size();i++){
            if(steps.containsKey(wordList.get(i)) && steps.get(wordList.get(i)) == step && oneDifferentChar(beginWord,wordList.get(i))){
                list.add(wordList.get(i));
                dfs(wordList.get(i),endWord,wordList,step+1);
                list.remove(step);
            }
        }
    }

    private boolean oneDifferentChar(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        String[] s = new String[]{"a","b","c"};
        String begin = "a";
        String end = "c";
        List<String> wordList = new ArrayList<String>();
        for (String noMeaning : s
        ) {
            wordList.add(noMeaning);
        }
        new D_126().findLadders(begin, end, wordList);
    }

}
