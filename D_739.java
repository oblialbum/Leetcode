package com.fengtin.LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class D_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if(stack.isEmpty()){
                stack.addFirst(i);
            }
            else{
                while (!stack.isEmpty() && temperatures[i] > temperatures [stack.peek()]){
                    ans[stack.peek()] = i - stack.peek();
                    stack.removeFirst();
                }
                stack.addFirst(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new D_739().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }
}
