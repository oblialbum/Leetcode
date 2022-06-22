package com.fengtin.LeetCode;

public class D_389 {
    public char findTheDifference(String s, String t) {
        int[] visited = new int[26];
        for(int i = 0;i < s.length();i++){
            visited[s.charAt(i) - 'a']++;
            visited[t.charAt(i) - 'a']++;
        }
        visited[t.charAt(t.length()-1) - 'a']++;
        for(int i = 0;i < visited.length;i++){
            if(visited[i] == 1){
                return (char)('a' + i);
            }
        }
        return '1';
    }
}
