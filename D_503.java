package com.fengtin.LeetCode;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class D_503 {
    public static void main(String[] args) {
        new D_503().nextGreaterElements(new int[]{1, 2, 1});
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int max = Integer.MIN_VALUE, cnt = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                cnt = 1;
                set.clear();
                set.add(i);
            } else if (nums[i] == max) {
                cnt++;
                set.add(i);
            }
        }
        for (int index : set
        ) {
            ans[index] = -1;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                ans[stack.peek()] = i;
                stack.removeFirst();
            }
            if (nums[i] == max) {
                continue;
            }
            stack.addFirst(i);
        }
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                ans[stack.peek()] = i;
                stack.removeFirst();
            }
        }

        for (int i = 0; i < n; i++) {
            if (ans[i] == -1) {
                continue;
            }
            ans[i] = nums[ans[i]];
        }
        return ans;
    }
}
