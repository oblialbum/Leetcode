package com.fengtin.LeetCode;

import java.util.*;

public class D_2039 {
    int[] times;
    Map<Integer, HashSet<Integer>> graph ;
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        graph = new HashMap<>();
        times = new int[n];
        for (int[] edge:edges
             ) {
            if (edge[0] > edge[1]){
                int t = edge[0];
                edge[0] = edge[1];
                edge[1] = t;
            }
            Set<Integer> set;
             set = graph.getOrDefault(edge[0],new HashSet<>());
            set.add(edge[1]);
            graph.put(edge[0], (HashSet<Integer>) set);
            set = graph.getOrDefault(edge[1],new HashSet<>());
            set.add(edge[0]);
            graph.put(edge[1], (HashSet<Integer>) set);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        int time = 0;
        while (!queue.isEmpty()){
            int curSize = queue.size();
            time++;
            for (int i = 0; i < curSize; i++) {
                int curNode = queue.poll();
                for (int next:graph.getOrDefault(curNode,new HashSet<>())
                     ) {
                    if (times[next] == 0 && next != 0) {
                        queue.offer(next);
                        times[next] = time;
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            //该节点在下次发出消息之前就收获了回复，最早空闲时间为所有该类型节点收到回复的最晚时间。
            if (patience[i] >= 2* times[i]){
                res = Math.max(res,2 * times[i] + 1);
            }else{
                //该节点恢复空闲需要的时间:
                int temp = 2 *times[i] / patience[i];
                if (2 *times[i] % patience[i] == 0){
                    temp -= 1;
                }
                res = Math.max(res,2 * times[i] + temp * patience[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new D_2039().networkBecomesIdle(new int[][]{{0,1},{1,2}},new int[]{0,2,1});
    }
}
