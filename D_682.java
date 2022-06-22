package com.fengtin.LeetCode;

import java.util.Stack;

public class D_682 {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            String cur = ops[i];
            if (cur.equals("+")){
                int first = stack.pop(),second = stack.peek();
                stack.push(first);
                stack.push(first + second);
            }else if(cur.equals("D")){
                stack.push(stack.peek() * 2);
            }else if(cur.equals("C")){
                stack.pop();
            }else{
                stack.push(Integer.valueOf(cur));
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
