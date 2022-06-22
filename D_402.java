package com.fengtin.LeetCode;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class D_402 {
    public String removeKdigits(String num, int k) {
        if(num.length() == k){
            return "0";
        }
        int n = num.length();
        int target = n - k;
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n && k >= 0; i++) {
            while (!stack.isEmpty() && num.charAt(i) < num.charAt(stack.peek())){
                set.add(stack.peek());
                stack.pollFirst();
                k--;
                if (k == 0){
                    break;
                }
            }
            if(k == 0){
                break;
            }
            stack.addFirst(i);
        }
        boolean prefixZero = true;
        for (int i = 0; i < n && target > 0; i++) {
            if(set.contains(i)){
                continue;
            }
            if(prefixZero && num.charAt(i) == '0'){
                target--;
                continue;
            }
            sb.append(num.charAt(i));
            prefixZero = false;
            target--;

        }
        if(sb.length() == 0){
            return "0";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new D_402().removeKdigits("123454",3);
    }
}
