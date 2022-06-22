package com.fengtin.LeetCode;

import java.util.*;

public class D_310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = null;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] degree = new int[n];
        for (int[] edge: edges
             ) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            Set<Integer> set1 = map.getOrDefault(edge[0],new HashSet<>());
            Set<Integer> set2 = map.getOrDefault(edge[1],new HashSet<>());
            set1.add(edge[1]);
            set2.add(edge[0]);
            map.put(edge[0],set1);
            map.put(edge[1],set2);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(degree[i] == 1){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            ans = new ArrayList<>();
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                int cur = queue.poll();
                ans.add(cur);
                for (int next: map.get(cur)
                     ) {
                    degree[next]--;
                    if(degree[next] == 1){
                        queue.offer(next);
                    }
                }
            }
        }
        return ans;
    }


    public static void main(String[] args){
        new D_310().findMinHeightTrees(4,new int[][]{{1,0},{1,2},{1,3}});
    }
}
