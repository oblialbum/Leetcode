package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_151 {
    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        s = s.trim();
        int begin = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                list.add(s.substring(begin,i));
                while (i < s.length() && s.charAt(i++) == ' '){

                }
                begin = i;
            }
        }
        list.add(s.substring(begin));
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i  >= 0; i--) {
            sb.append(list.get(i));
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
