package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class D_282 {
    List<String> ans = new ArrayList<>();
    StringBuffer sb = new StringBuffer();

    /**
     * sum和实际的表达式值不同，最后再计算表达式的值可以。
     * 注意每个值不能以0开始。
     * @param num
     * @param target
     * @return
     */
    int target;
    public List<String> addOperators(String num, int target) {
        this.target = target;
        if(num.length() == 1){
            if(target == Integer.parseInt(num)){
                ans.add(num);
                return ans;
            }
        }
        sb.append(num.charAt(0));
        dfs(num,target,1);
        return ans;
    }

    private void dfs(String num, int target,int pos) {
        if(pos == num.length()){
            if(calculate(sb.toString()) == target){
                ans.add(sb.toString());
            }
            return;
        }
        sb.append("+"+num.charAt(pos));
        dfs(num,target,pos+1);
        sb.replace(sb.length()-2,sb.length() - 1,"-");
        dfs(num,target,pos+1);
        sb.replace(sb.length()-2,sb.length() - 1,"*");
        dfs(num,target,pos+1);
        sb.delete(sb.length() - 2,sb.length());
        sb.append(num.charAt(pos));
        dfs(num,target,pos+1);
        sb.delete(sb.length() - 1,sb.length());
    }

    private long calculate(String s) {
        Stack<Long> num = new Stack<>();
        Stack<Character> operator = new Stack<>();
        long sum = 0;
        for(int i = 0;i < s.length();i++){
            char  c = s.charAt(i);
            /**
             * 数字中存在前导0
             */
            if(c == '0' && i > 0 && i < s.length() - 1 && !Character.isDigit(s.charAt(i - 1)) && Character.isDigit(s.charAt(i + 1))){
                return Long.MAX_VALUE;
            }
            else if(c == '0' && i == 0 && Character.isDigit(s.charAt(i + 1))){
                return Long.MAX_VALUE;
            }
            if(c <= '9' && c >='0'){
                sum *= 10;
                sum += c - '0';
            }
            else{
                num.push(sum);
                if(operator.isEmpty()){
                    operator.push(c);
                }
                else {
                    if (getPrity(c) > getPrity(operator.peek())) {
                        operator.push(c);
                    }
                    else{
                        while (true){
                            long num1 = num.pop();
                            long num2 = num.pop();
                            num.push(getAns(num2,num1,operator.pop()));
                            if(operator.isEmpty() || getPrity(c) > getPrity(operator.peek())){
                                operator.push(c);
                                break;
                            }
                        }
                    }
                }
                sum = 0;
            }
            if(i == s.length() - 1){
                num.push(sum);
            }
        }
        while(!operator.isEmpty()){
            long num1 = num.pop();
            long num2 = num.pop();
            num.push(getAns(num2,num1,operator.pop()));
        }
        if(num.peek() == target){
            System.out.println(sb.toString());
        }
        return num.peek();
    }

    private int getPrity(char c){
        if(c == '*' || c == '/'){
            return 2;
        }
        return 1;
    }

    private long getAns(long num1,long num2,char c){
        if(c == '*'){
            return num1 * num2;
        }
        if(c == '+'){
            return num1 + num2;
        }
        return num1 - num2;
    }

    public static void main(String[] args){
        new D_282().calculate("1+2+3+4+5-6*7-8*9");
        //System.out.println(Math.pow(3,10) * 10);
    }
}
