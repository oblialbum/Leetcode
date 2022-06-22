package com.fengtin.LeetCode;

public class D_242 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] visited = new int[26];
        for(int i = 0;i < s.length(); i++){
            visited[s.charAt(i) - 'A']++;
            visited[t.charAt(i) - 'A']--;
        }
        for (int num: visited
             ) {
            if(num != 0){
                return false;
            }
        }
        return true;
    }
}
