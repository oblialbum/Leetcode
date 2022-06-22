package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class D_139 {
    Set<Integer> memo = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1;i <= s.length();i++){
            for(int j = 0;j < i;j++){
                if(dp[j] && words.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    private boolean dfs(String s, HashSet<String> wordDict, int pos) {
        if (pos == -1) {
            return true;
        }
        /**
         * 剪枝一：从后往前遍历。
         */
        for (int i = pos; i >= 0; i--) {
            if (!wordDict.contains(s.substring(i, pos+1))) {
                continue;
            }
            /**
             * 剪枝二：memo记录已经测试过但是未成功的下标。
             */
            if(memo.contains(i)){
                continue;
            }
            if(dfs(s, wordDict, i - 1)){
                return true;
            }
            memo.add(i);
        }
        return false;
    }

    public static void main(String[] args){
        String s= "a";
        List<String> words = new ArrayList<>();
        words.add("a");
        new D_139().wordBreak(s,words);
    }
}
