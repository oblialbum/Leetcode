package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class D_279 {
    int steps = Integer.MAX_VALUE;
    Map<Integer, Integer> map = new HashMap<>();
    public int numSquares(int n) {
        traceBack(n,0);
        return steps;
    }

    private void traceBack(int n, int step) {
        if(n == 0){
            steps = Math.min(steps,step);
        }
        if(step >= steps){
            return;
        }
        if(!map.containsKey(n)){
            map.put(n,step);
        }
        else{
            if(step >= map.get(n)){
                return;
            }
            else{
                map.replace(n,step);
            }
        }
        for(int i = (int)Math.sqrt(n);i > 0;i--){
            traceBack(n - i*i,step+1);
        }
    }

    public static void main(String[] args){
        new D_279().numSquares(12);
    }
}
