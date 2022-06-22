package com.fengtin.LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class D_1673 {
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offer(-1);
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] < stack.peekLast() && k - stack.size() + 1 < nums.length- i){
                stack.pollLast();
            }
            if (stack.size() < k + 1) {
                stack.offer(nums[i]);
            }
        }
        int[] res = new int[k];
        while (k > 0){
            res[--k] = stack.pollLast();
        }
        return res;
    }

    public static void main(String[] args) {
        new D_1673().mostCompetitive(new int[]{3,5,2,6},2);
    }
}
