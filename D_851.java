package com.fengtin.LeetCode;

import java.util.*;

public class D_851 {
    int min ;
    boolean[] visited ;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        visited = new boolean[n];
        for (int i = 0; i < richer.length; i++) {
            Set<Integer> set = map.getOrDefault(richer[i][1],new HashSet<>());
            set.add(richer[i][0]);
            map.put(richer[i][1],set);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            min = i;
            dfs(map,i,quiet);
            res[i] = min;
            Arrays.fill(visited,false);
        }
        return res;
    }

    private void dfs(Map<Integer, Set<Integer>> map, int cur, int[] quiet) {
        if(visited[cur]){
            return;
        }
        visited[cur] = true;
        if(quiet[cur] < quiet[min]){
            min = cur;
        }
        for (int big: map.getOrDefault(cur,new HashSet<>())
             ) {
            dfs(map,big,quiet);
        }
    }
}
