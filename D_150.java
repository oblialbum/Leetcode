package com.fengtin.LeetCode;

import java.util.Stack;

public class D_150 {
    /**
     * 后缀转中缀。
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> operationStack = new Stack<>();
        for(int i = 0;i < tokens.length;i++){
            if(isDigit(tokens[i])){
                numStack.push(Integer.valueOf(tokens[i]));
            }
            else{
                numStack.push(caculate(numStack.pop(),numStack.pop(),tokens[i]));
            }
        }
        return numStack.pop();
    }

    private Integer caculate(Integer second, Integer first, String token) {
        int ans = 0;
        if("*".equals(token)){
            ans = first * second;
        }
        if("/".equals(token)){
            ans = first / second;
        }
        if("-".equals(token)){
            ans = first - second;
        }
        if("+".equals(token)){
            ans = first + second;
        }
        return ans;
    }

    private boolean isDigit(String token) {
        int begin = 0;
        if(token.startsWith("-")){
            begin = 1;
        }
        for(int i = begin;i < token.length();i++){
            if(!Character.isDigit(token.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        new D_150().evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"});
    }
}
