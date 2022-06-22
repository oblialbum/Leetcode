package com.fengtin.LeetCode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class D_316 {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        int[] occur = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            occur[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            occur[c - 'a']--;
            if(set.contains(c)){
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek()){
                if(occur[stack.peek() - 'a'] > 0){
                    set.remove(stack.pop());
                }
                else {
                    break;
                }
            }
            if(set.add(c)){
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        new D_316().removeDuplicateLetters("bbcaac");
    }
}
