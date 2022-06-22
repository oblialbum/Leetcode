package com.fengtin.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class D_1763 {
    public String longestNiceSubstring(String s) {
        int l = -1,r = -1,length = 0;
        int n = s.length();
        for (int i = 0;i < n;i++){
            for (int j = i + 1;j <= n;j++){
                if (check(s.substring(i,j))){
                    if ((j - i) > length){
                        l = i;
                        r = j;
                        length = j - i;
                    }
                }
            }
        }
        if (l == -1){
            return "";
        }
        return s.substring(l,r);
    }

    private boolean check(String s){
        Set<Character> set = new HashSet<>();
        for (int i = 0;i < s.length();i++){
            set.add(s.charAt(i));
        }
        for (Character key:set
        ) {
            if (Character.isLowerCase(key)){
                if (!set.contains((char)(key - 32))){
                    return false;
                }
            }
            else if (Character.isUpperCase(key)){
                if (!set.contains((char)(key + 32))){
                    return false;
                }
            }
        }
        return true;
    }
}
