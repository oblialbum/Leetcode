package com.fengtin.LeetCode;

public class D_686 {
    public int repeatedStringMatch(String a, String b) {
        //  判断是否包含b中的字符。
        //  b是a的子串 true
        //  如果b能由多个a叠加而成，b在a中一定有一个起始字符，从该字符到a的末尾一定全部相同。
        //  最小叠加下界：向上取整 b/a ，b/a + 1.
        int[] occur1 = new int[26];
        int[] occur2 = new int[26];
        for (int i = 0; i < a.length(); i++) {
            occur1[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            occur2[b.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (occur1[i] == 0 && occur2[i] != 0){
                return -1;
            }
        }
        StringBuilder sb = new StringBuilder();
        int min = (b.length() + a.length() - 1) / a.length();
        for (int i = 0; i < min; i++) {
            sb.append(a);
        }
        if (sb.indexOf(b) != -1){
            return min;
        }
        sb.append(a);
        return sb.indexOf(b) == -1 ? -1: min + 1;
    }
}
