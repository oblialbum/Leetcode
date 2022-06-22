package com.fengtin.LeetCode;

import java.util.*;

public class D_1462 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] prerequisity: prerequisites
        ) {
            HashSet<Integer> set = map.getOrDefault(prerequisity[0],new HashSet<>());
            set.add(prerequisity[1]);
            map.put(prerequisity[0],set);
        }
        Map<Integer, HashSet<Integer>> next = new HashMap<>();
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            HashSet<Integer> set = next.getOrDefault(i,new HashSet<>());
            dfs(i,map,set,visited);
            next.put(i,set);
            Arrays.fill(visited, false);
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] query:queries
             ) {
            res.add(next.get(query[0]).contains(query[1]));
        }
        return res;
    }

    private void dfs(int node, Map<Integer, HashSet<Integer>> map, HashSet<Integer> set,boolean[] visited) {
        for (int nextNode:map.getOrDefault(node,new HashSet<>())
             ) {
            if(visited[nextNode]){
                continue;
            }
            visited[nextNode] = true;
            set.add(nextNode);
            dfs(nextNode,map,set,visited);
        }
    }

    public static void main(String[] args) {
        new D_1462().checkIfPrerequisite(3,new int[][]{{1,0},{1,2},{2,0}}, new int[][]{});
    }
}
