package com.fengtin.LeetCode;

public class D_1143 {
    /**
     * DP[i][j]:text1[0..i]和text2[0..j]的最长公共子序列。
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(longestCommonSubsequence(text1,text2,dp));
        return dp[m][n];
    }

    /**
     * 根据上面的DP矩阵回溯得到最长公共子序列。
     * @param s1
     * @param s2
     * @param dp
     * @return
     */
    public String longestCommonSubsequence(String s1,String s2,int[][] dp){
        int m = s1.length(),n = s2.length();
        StringBuilder sb = new StringBuilder();
        for (int i = m,j = n; i >0 && j > 0 ;) {
            if (dp[i][j] == dp[i-1][j-1] + 1 && s1.charAt(i - 1) == s2.charAt(j - 1)){
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            }else if (dp[i][j] == dp[i][j - 1]){
                j--;
            }else{
                i--;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        new D_1143().longestCommonSubsequence("abcde","abce");
    }
}
