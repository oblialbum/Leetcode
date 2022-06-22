package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_467 {
    public int findSubstringInWraproundString(String p) {
        //如果S[i,j]是一个符合条件的子串，那么该子串的所有子串均符合条件，
        //然后从S[j+1,...]开始判断最长的子串是哪一个，一直迭代到最后。
        //如何判断不同的子串？
        //MD，DP！！！判断以某个字符结尾的最长子串的长度，则可以直到该字符贡献了多少个不同子串。
        //eg.. DP[3] = 3,则存在子串bcd,贡献了3个不同子串。
        int[] dp = new int[26];
        int k = 0;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1){
                k++;
            }else{
                k = 1;
            }
            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'],k);
        }
        return Arrays.stream(dp).sum();
    }
}
