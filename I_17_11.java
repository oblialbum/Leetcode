package com.fengtin.LeetCode;

public class I_17_11 {
    public int findClosest(String[] words, String word1, String word2) {
        int pre = -1,res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)){
                if (pre != -1 && words[pre].equals(word2)){
                    res = Math.min(res,i - pre);
                }
                pre = i;
            }
            if (words[i].equals(word2)){
                if (pre != -1 && words[pre].equals(word1)){
                    res = Math.min(res,i - pre);
                }
                pre = i;
            }
        }
        return res;
    }
}
