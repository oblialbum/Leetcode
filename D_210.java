package com.fengtin.LeetCode;

import java.util.*;

public class D_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //图是联通的，存在拓扑排序。
        int n = numCourses;
        int[] inDegree = new int[n];
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] prerequisity: prerequisites
             ) {
            inDegree[prerequisity[0]]++;
            HashSet<Integer> set = map.getOrDefault(prerequisity[1],new HashSet<>());
            set.add(prerequisity[0]);
            map.put(prerequisity[1],set);
        }
        Queue<Integer> queue =new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        int cnt = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(inDegree[i] == 0){
                queue.offer(i);
                visited[i] = true;
                res.add(i);
                cnt++;
            }
        }
        while (!queue.isEmpty()){
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                int cur = queue.poll();
                for (int neighbor:map.getOrDefault(cur,new HashSet<>())
                     ) {
                    if(visited[neighbor]){
                        continue;
                    }
                    inDegree[neighbor] -= 1;
                    if(inDegree[neighbor] == 0){
                        queue.offer(neighbor);
                        visited[neighbor] = true;
                        res.add(neighbor);
                        cnt++;
                    }
                }
            }
        }
        if(cnt != n){
            return new int[]{};
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
