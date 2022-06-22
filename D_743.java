package com.fengtin.LeetCode;

import java.util.*;

public class D_743 {
    static int INTMAX = 0x3f3f3f3f;

    /**
     * BFS
     * @param times
     * @param n
     * @param k
     * @return
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] edg : times) {
            if (!map.containsKey(edg[0])) {
                map.put(edg[0], new HashMap<>());
            }
            map.get(edg[0]).put(edg[1], edg[2]);
        }
        /**
         * 记录到达其他节点的时间。
         */
        int[] dis = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            dis[i] = INTMAX;
        }
        dis[k] = 0;

        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[] { k, 0 });

        while (!queue.isEmpty()){
            int[] root = queue.poll();
            Map<Integer,Integer> edges = map.getOrDefault(root[0],new HashMap<>());
            for (int node:edges.keySet()
                 ) {
                int curTime = edges.get(node) + root[1];
                if(curTime < dis[node]) {
                    dis[node] = curTime;
                    queue.offer(new int[]{node, curTime});
                }
            }
        }
        int mint = -1;
        for (int time: dis
             ) {
            mint = Math.max(time,mint);
        }
        return mint == INTMAX ? -1 : mint;
    }


    /**
     * DFS
     */
    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    int[] dis;
    public int networkDelayTime2(int[][] times, int n, int k) {
        for (int[] edg : times) {
            if (!map.containsKey(edg[0])) {
                map.put(edg[0], new HashMap<>());
            }
            map.get(edg[0]).put(edg[1], edg[2]);
        }
        /**
         * 记录到达其他节点的时间。
         */
        dis = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            dis[i] = INTMAX;
        }
        dfs(k,0);
        int mint = -1;
        for (int time: dis
        ) {
            mint = Math.max(time,mint);
        }
        return mint == INTMAX ? -1 : mint;
    }

    private void dfs(int pos, int time) {
        if(time >= dis[pos]){
            return;
        }
        dis[pos] = time;
        Map<Integer,Integer> edges = map.getOrDefault(pos,new HashMap<>());
        for (int node: edges.keySet()
             ) {
            dfs(node,time + edges.get(node));
        }
    }
}
