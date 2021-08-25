package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_784 {
    public static List<String> letterCasePermutation(String s) {
        List<String> answer = new ArrayList();
        char[] c = s.toCharArray();
        dfs(c, answer, 0);
        return answer;
    }

    private static void dfs(char[] s, List<String> ans, int pos) {
        if (pos == s.length) {
            ans.add(new String(s));
            return;
        }

        if (Character.isDigit(s[pos])) {
            dfs(s, ans, pos + 1);
            return;
        }
        dfs(s, ans, pos + 1);
        transform(s, pos);
        dfs(s, ans, pos + 1);
    }

    private static void transform(char[] s, int pos) {
        if (Character.isLowerCase(s[pos])) {
            s[pos] -= 32;
        } else {
            s[pos] += 32;
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCasePermutation("3z4"));
    }
}
