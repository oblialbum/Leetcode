package com.fengtin.LeetCode;

public class D_115 {
    /**
     * DP[i][j]:s[0..i]的子序列中包含多少个t[0..j]
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        int[][] DP= new int[s.length()][t.length()];
        DP[0][0] = s.charAt(0) == t.charAt(0) ? 1: 0;
        for(int i = 1;i < s.length(); i++){
            DP[i][0] = DP[i - 1][0] + (s.charAt(i) == t.charAt(0) ? 1: 0);
        }
        for(int i = 1;i < s.length();i++){
            for(int j = 1;j <= Math.min(i,t.length() - 1);j++){
                if(s.charAt(i) == t.charAt(j)){
                    DP[i][j] = DP[i - 1][j] + DP[i - 1][j - 1];
                }
                else{
                    DP[i][j] = DP[i - 1][j];
                }
            }
        }
        return DP[s.length() - 1][t.length() - 1];
    }

    public static void main(String[] args){
        new D_115().numDistinct("babgbag","bag");
    }
}
