package com.fengtin.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class D_20 {
    /**
     * j,k,l分别指代小中大括号的匹配数量，遇见左括号-1，右括号+1。
     * 遍历过程中出现任意j,k,l >0，出错。最后判断三者==0;
     * <p>
     * 上述思想错误。
     * 左括号必须以正确的顺序闭合。 eg.. ([)] false
     * <p>
     * 用stack?空间N，时间N。
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s.length() == 0 || s.length() % 2 == 1) {
            return false;
        }
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
                continue;
            }
            if(stack.isEmpty()){
                return false;
            }
            char c = stack.pop();
            if (c == '(' && s.charAt(i) != ')') {
                return false;
            }
            if (c == '[' && s.charAt(i) != ']') {
                return false;
            }
            if (c == '{' && s.charAt(i) != '}') {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
