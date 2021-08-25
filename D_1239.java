package com.fengtin.LeetCode;

import java.util.*;

public class D_1239 {
    int length = 0;
    public int maxLength(List<String> arr) {
        String[] s =new String[arr.size()];
        for(int i = 0;i < s.length;i++){
            s[i] = arr.remove(0);
        }
        boolean[] visited = new boolean[26];
        Arrays.sort(s);
        dfs(s,0,visited,0);
        return length;
    }
    private void dfs(String[] s,int pos,boolean[] visited,int sum){
        int i ;
        for( i = pos;i < s.length;i++){
            if(s[i].length() > 26 - sum){
                continue;
            }
            if(containSameChar(s[i])){
                continue;
            }
            if(!containSameChar(s[i],visited)){
                for(int j = 0;j < s[i].length();j++){
                    visited[s[i].charAt(j)-'a'] = true;
                }
                dfs(s,i+1,visited,sum+s[i].length());
                for(int j = 0;j < s[i].length();j++){
                    visited[s[i].charAt(j)-'a'] = false;
                }
            }
        }
        if(i == s.length){
            if(sum > length){
                length = sum;
            }
            return;
        }
    }

    private boolean containSameChar(String s,boolean[] visited){
        for(int i = 0;i < s.length();i++){
            if(visited[s.charAt(i) - 'a']){
                return true;
            }
        }
        return false;
    }
    private boolean containSameChar(String s){
        HashSet<Character> set = new HashSet<Character>();
        for(int i = 0;i < s.length();i++){
            if(set.contains(s.charAt(i))){
                return true;
            }
            else{
                set.add(s.charAt(i));
            }
        }
        return false;
    }

    public static void main(String[] args){
        List<String> arr = new ArrayList<String>();
        arr.add("jnfbyktlrqumowxd");
        arr.add("mvhgcpxnjzrdei");
        //["jnfbyktlrqumowxd","mvhgcpxnjzrdei"]
        System.out.println(new D_1239().maxLength(arr));
        String[] s = new String[]{"b","ac"};
        Arrays.sort(s,new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for (String i: s
             ) {
            System.out.println(i);
        }
    }
}
