package com.fengtin.LeetCode;

public class D_97 {
    /**
     * DP[i][j]:截止到S1的第I个字符，S2的第J个字符，是否可以组成S3的前（i+j）个字符。
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()){
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        /**
         * 初始化DP。
         */
        for(int i = 1;i < s2.length() + 1; i++){
            dp[0][i] = dp[0][i-1] && s2.charAt(i - 1) == s3.charAt(0 + i - 1);
        }
        for(int i = 1;i < s1.length() + 1; i++){
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(0 + i - 1);
        }
        for(int i = 1;i < s1.length() + 1;i++){
            for(int j = 1;j < s2.length() + 1;j++){
                boolean left = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                boolean top = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                dp[i][j] = top || left;
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args){
        new D_97().isInterleave("aabcc","dbbca","aadbbcbcac");
    }
}
