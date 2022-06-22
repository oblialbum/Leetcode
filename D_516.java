package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class D_516 {
    /**
     * DP[i][j]:s[i..j]中最长回文子序列。
     * @param s
     * @return
     */
    int ans = 0 ;
    Map<String,Integer> map = new HashMap<>();
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dfs(s,0,new StringBuffer());
        return ans;
    }

    private void dfs(String s, int pos, StringBuffer sb) {
        if(pos == s.length()){
            if(isPalindrome(sb)){
                ans = Math.max(ans,sb.length());
            }
            return;
        }
        dfs(s,pos + 1,sb);
        sb.append(s.charAt(pos));
        dfs(s,pos + 1,sb);
        sb.deleteCharAt(sb.length() - 1);
    }


    private boolean isPalindrome(StringBuffer sb) {
        if(sb.length() == 0){
            map.put(sb.toString(), sb.length());
            return true;
        }
        if(sb.length() == 1){
            map.put(sb.toString(), sb.length());
            return true;
        }
        if(sb.charAt(0) != sb.charAt(sb.length() - 1)){
            return false;
        }
        if(!map.containsKey(sb.substring(1,sb.length() - 1))){
            return false;
        }
        map.put(sb.toString(), sb.length());
        return true;
    }

    public static void main(String[] args){
        long begin = System.currentTimeMillis();
        new D_516().longestPalindromeSubseq("euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew");
        System.out.println(System.currentTimeMillis() - begin + ":ms");
    }
}
