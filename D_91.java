package com.fengtin.LeetCode;

public class D_91 {
    int decodeNum = 0;
    int[] memo;
    /**
     * 0开头不行，没有以0开头的映射。
     * DP问题，记忆化搜索如何实现？
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        memo = new int[s.length()];
        dfs(s,0);
        return decodeNum;
    }

    private void dfs(String s, int pos){
        if(pos == s.length()){
            decodeNum++;
            return;
        }
        if(s.charAt(pos) == '0'){
            return;
        }
        for(int i = pos + 1;i <= s.length() && i < pos +3; i++){
            int curNum = Integer.parseInt(s.substring(pos, i));
            if(curNum >=1 && curNum <=26){
                dfs(s,i);
            }
        }
    }

    public static void main(String[] args){
        new D_91().numDecodings("2226");
    }
}
