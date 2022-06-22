package com.fengtin.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class D_720 {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        set.add("");
        for (String word: words
             ) {
            if(set.contains(word.substring(0,word.length() - 1))){
                set.add(word);
            }
        }
        int maxLength = 0;
        String ans = "";
        for (String word:set
             ) {
            if(word.length() > maxLength){
                ans = word;
                maxLength = word.length();
            }
            else if(word.length() == maxLength && word.compareTo(ans) < 0){
                ans = word;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        new D_720().longestWord(new String[]{"b","br","bre","brea","break","breakf","breakfa","breakfas","breakfast","l","lu","lun","lunc","lunch","d","di","din","dinn","dinne","dinner"});
    }
}
