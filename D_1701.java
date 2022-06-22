package com.fengtin.LeetCode;

import java.util.ArrayDeque;
import java.util.Queue;

public class D_1701 {

    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double sum = 0.0;
        Queue<int[]> queue = new ArrayDeque<>();
        int time = customers[0][0];
        for (int index = 0;index < n;){
            if(time >= customers[index][0]){
                queue.offer(customers[index]);
                index++;
            }
            else{
                if(queue.isEmpty()){
                    time = customers[index][0];
                    continue;
                }
                while (!queue.isEmpty()){
                    int[] cur = queue.poll();
                    time += cur[1];
                    sum += time - cur[0];
                }
            }
        }
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            time += cur[1];
            sum += time - cur[0];
        }
        return sum / n;
    }

    public static void main(String[] args){
        new D_1701().averageWaitingTime(new int[][]{{1,2},{2,5},{4,3}});
    }
}
