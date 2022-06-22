package com.fengtin.LeetCode;

public class D_1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuffer sb = new StringBuffer();
        int i ;
        for( i = 0;i < word1.length() && i < word2.length();i++){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if(i < word1.length()){
            sb.append(word1.substring(i));
        }
        if(i < word2.length()){
            sb.append(word2.substring(i));
        }
        return sb.toString();
    }
}
