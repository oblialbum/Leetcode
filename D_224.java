package com.fengtin.LeetCode;

public class D_224 {
    public int calculate(String s) {
        return dfs(s,0,s.length());
    }

    private int dfs(String s, int pos, int end) {
        int ans = 0;
        int add = 1;
        for (int i = pos; i < end; i++) {
            char c = s.charAt(i);
            if (c == ' '){
                continue;
            }
            if (Character.isDigit(c)) {
                int num = 0;
                for (int j = i; j < end && Character.isDigit(s.charAt(j)); j++) {
                    num *= 10;
                    num += s.charAt(j) -'0';
                    i = j;
                }
                ans +=  num * add;
            }
            if (c == '+'){
                add = 1;
            }
            if (c == '-'){
                add = -1;
            }
            if (c == '('){
                int idx = find(s,i);
                ans += add * dfs(s,i + 1,idx);
                i = idx;
            }
        }
        return ans;
    }

    private int find(String s, int pos) {
        int balance = 0;
        for (int i = pos; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '('){
                balance++;
            }
            if (c == ')'){
                balance--;
                if (balance == 0){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new D_224().calculate("2147483647");
    }
}
