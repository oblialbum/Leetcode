package com.fengtin.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class D_929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(int i = 0;i < emails.length;i++){
            String[] email = emails[i].split("@");
            StringBuilder sb = new StringBuilder();
            for(char c : email[0].toCharArray()){
                if (c == '.'){
                    continue;
                }
                if (c == '+'){
                    break;
                }
                sb.append(c);
            }
            sb.append('@');
            sb.append(email[1]);
            set.add(sb.toString());
        }
        return set.size();
    }
}
