package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_386 {
    List<Integer> res;
    public List<Integer> lexicalOrder(int n) {
        res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i,n);
        }
        return res;
    }

    private void dfs(int cur,int n) {
        if (cur > n){
            return ;
        }
        res.add(cur);
        for (int i = 0; i <= 9; i++) {
            dfs(cur * 10 + i,n);
        }
    }
}
