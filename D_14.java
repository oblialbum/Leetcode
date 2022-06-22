package com.fengtin.LeetCode;

public class D_14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        }
        String s = strs[0];
        int pos = 1;
        while(!"".equals(s) && pos < strs.length){
            s = getLongestCommonPrefix(s,strs[pos++]);
        }
        return s;
    }

    private String getLongestCommonPrefix(String s, String str) {
        for(int i = 0;i < s.length() && i < str.length(); i++){
            if(s.charAt(i) != str.charAt(i)){
                return s.substring(0,i);
            }
        }
        return s.substring(0,Math.min(s.length(),str.length()));
    }
    public static void main(String[] args){
        String[] s = new String[]{"flower","flow","flight"};
        new D_14().longestCommonPrefix(s);
    }
}
