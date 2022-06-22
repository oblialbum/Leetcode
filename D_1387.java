package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class D_1387 {
    Map<Integer,Integer> map ;
    public int getKth(int lo, int hi, int k) {
        map = new HashMap<>();
        map.put(1,0);
        for (int i = lo; i <= hi ; i++) {
            dfs(i);
        }
        //再来个排序.
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) ->(x[1] == y [1] ? x[0] - y[0] : x[1] - y[1]));
        for (int i = lo; i <=hi ; i++) {
            pq.add(new int[]{i,map.get(i)});
        }
        while (k > 1){
            pq.poll();
            k--;
        }
        return pq.peek()[0];
    }

    private void dfs(int n) {
        if (map.containsKey(n)){
            return;
        }
        if (n % 2 == 0){
            if (!map.containsKey(n / 2)){
                dfs(n / 2);
            }
            map.put(n,map.get(n / 2) + 1);
        }else{
            if (!map.containsKey(3 * n + 1)){
                dfs(3 * n + 1);
            }
            map.put(n,map.get(3 * n + 1) + 1);
        }
    }

    public static void main(String[] args) {
        new D_1387().getKth(1,1000,201);
    }
}
