package com.fengtin.LeetCode;

public class D_345 {
    char[] right = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

    public String reverseVowels(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        char[] ch = s.toCharArray();
        for (int i = 0, j = ch.length - 1; i < j; ) {
            if (isRight(ch[i]) && isRight(ch[j])) {
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                i++;
                j--;
                continue;
            }
            if (isRight(ch[i])) {
                j--;
                continue;
            }
            if (isRight(ch[j])) {
                i++;
                continue;
            }
            i++;
            j--;
        }
        return new String(ch);
    }

    private boolean isRight(char ch) {
        for (int i = 0; i < right.length; i++) {
            if (right[i] == ch) {
                return true;
            }
        }
        return false;
    }
}
