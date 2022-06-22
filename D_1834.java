package com.fengtin.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class D_1834 {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] task = new int[n][3];
        for(int i = 0;i < n;i++){
            task[i][0] = tasks[i][0];
            task[i][1] = tasks[i][1];
            task[i][2] = i;
        }
        Arrays.sort(task, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1] == 0 ? o1[2] - o2[2] : o1[1] - o2[1];
            }
        });
        int endTime = 1,p = 0;
        int[] ans = new int[n];
        for(int i = 0;i < n;){
            /**
             * 当前没有进程在处理，且下一个进程还未进入。
             */
            if(minHeap.isEmpty() && task[i][0] > endTime){
                endTime = task[i][0];
            }
            if(task[i][0] <= endTime){
                minHeap.add(task[i]);
                i++;
            }
            else{
                if (minHeap.isEmpty()){
                    continue;
                }
                /**
                 * 新的结束时间为当前处理过的进程的结束时间。
                 */
                int[] res = minHeap.poll();
                ans[p++] = res[2];
                endTime += res[1];
            }
        }
        while (!minHeap.isEmpty()){
           ans[p++] = minHeap.poll()[2];
        }
        return  ans;
    }

    public static  void main(String[] args){
        new D_1834().getOrder(new int[][]{{19,13},{16,9},{21,10},{32,25},{37,4},{49,24},{2,15},{38,41},{37,34},{33,6},{45,4},{18,18},{46,39},{12,24}});
    }
}
