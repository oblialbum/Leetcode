package com.fengtin.LeetCode;

public class D_1945 {
    public int getLucky(String s, int k) {
        StringBuffer sb = new StringBuffer();
        for (char c: s.toCharArray()
             ) {
            sb.append(c - 'a' + 1);
        }
        int sum = 0;
        while (k > 0){
            for(int i = 0;i < sb.length();i++){
                sum += sb.charAt(i) - '0';
            }
            sb.delete(0,sb.length());
            sb.append(sum);
            sum = 0;
            k--;
        }
        return Integer.parseInt(sb.toString());
    }
    public static void main(String[] args){
        new D_1945().getLucky("leetcode",2);
    }
}
