package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class D_1606 {
    /**
     * 记录每个服务器的空闲时间，time[i]表示第i第i各服务器从time[i]时间开始空闲。
     * 需要解决的是:从[i%k,i%k -1]中快速找到第一个空闲时间<=arrival[i].
     * @param k
     * @param arrival
     * @param load
     * @return
     */
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int n = arrival.length,max = 0;
        int[] cnts = new int[n];
        PriorityQueue<int[]> busy = new PriorityQueue<>((x,y)->x[1] - y[1]);
        TreeSet<Integer> free = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            free.add(i);
        }
        for (int i = 0; i < n; i++) {
            int start = arrival[i],end = start + load[i];
            while (!busy.isEmpty() && busy.peek()[1] <= start){
                free.add(busy.poll()[0]);
            }
            Integer ceiling = free.ceiling(i % k);
            if (ceiling == null){
                ceiling = free.ceiling(0);
            }
            if (ceiling == null){
                continue;
            }
            free.remove(ceiling);
            busy.add(new int[]{ceiling,end});
            cnts[ceiling]++;
            max = Math.max(cnts[ceiling],max);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cnts[i] == max){
                list.add(i);
            }
        }
        return list;
    }
}
