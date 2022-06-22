package com.fengtin.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class D_433 {
    Set<String> visited = new HashSet<>();
    int res = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        boolean flag = false;
        for (String temp:bank
             ) {
            if (temp.equals(end)){
                flag = true;
                break;
            }
        }
        if (!flag){
            return -1;
        }
        visited.add(start);
        dfs(start,end,bank,0);
        return res == Integer.MAX_VALUE ? -1:res;
    }

    private void dfs(String cur, String target, String[] bank,int cnt) {
        if (cur.equals(target)){
            res = Math.min(res,cnt);
        }
        if (isNext(cur,target)){
            res = Math.min(res,cnt+1);
        }
        for (String next:bank
             ) {
            if (visited.contains(next)){
                continue;
            }
            if (isNext(cur,next)){
                visited.add(next);
                dfs(next,target,bank,cnt+1);
                visited.remove(next);
            }
        }
    }

    private boolean isNext(String cur, String next) {
        int diff = 1;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) != next.charAt(i)){
                diff--;
                if (diff < 0){
                    return false;
                }
            }
        }
        return true;
    }
}
