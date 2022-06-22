package com.fengtin.LeetCode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class D_131 {
    boolean[][] DP;
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        DP = new boolean[s.length()][s.length()];
        for(int i = 0;i < s.length();i++){
            Arrays.fill(DP[i],true);
        }
        /**
         * 判断s[i...j]是否是一个回文串。
         * 求DP[i][j]之前需要先求其左下方的DP[i + 1][j - 1].
         * 所以需要从下到上的求解。
         */
        for(int i = s.length() - 2;i >= 0;i--){
            for(int j = i + 1;j < s.length();j++){
                DP[i][j] = DP[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        dfs(s,ans,new ArrayList<String>(),0);
        return ans;
    }
    private  void dfs(String s,List answer,List list,int pos){
        if(pos == s.length()){
            answer.add( new ArrayList(list));
            return;
        }
        for(int i = pos;i< s.length(); i++){
            if(s.charAt(i) == s.charAt(pos)){
                if(DP[pos][i]){
                    list.add(s.substring(pos,i+1));
                    dfs(s,answer,list,i+1);
                    list.remove(list.size()-1);
                }
            }
        }
    }

    public static void main(String[] args){
        new D_131().partition("abbab");
    }
}
