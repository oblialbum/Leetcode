package com.fengtin.LeetCode;

public class D_1816 {
    public String truncateSentence(String s, int k) {
        StringBuffer sb = new StringBuffer();
        for (char c: s.toCharArray()
             ) {
            if(c == ' '){
                k--;
            }
            sb.append(c);
            if(k == 0){
                break;
            }
        }
        if(sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
