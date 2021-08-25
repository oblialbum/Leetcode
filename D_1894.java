package com.fengtin.LeetCode;

public class D_1894 {
    public boolean splitString(String s) {
        long  sum = s.charAt(0) - '0';
        long theta = Integer.MAX_VALUE;
        for(int i = 1;i < s.length(); i++){
            if( sum > theta && i > 10 ){
                break;
            }
            if(dfs(i,sum,s)){
                return true;
            }
            sum = sum * 10+ s.charAt(i) - '0';
        }
        return false;
    }
    private boolean dfs(int begin,long pre,String s){
        if(begin == s.length()){
            return true;
        }
        for(int i = begin + 1;i <= s.length(); i++){
            Long cur = Long.parseLong(s.substring(begin, i));
            if(cur > pre){
                break;
            }
            if(cur - pre == -1){
                if(dfs(i, cur,s)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(new D_1894().splitString("99999999999999999998"));
    }
}
