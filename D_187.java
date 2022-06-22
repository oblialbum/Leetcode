package com.fengtin.LeetCode;

import java.util.*;

public class D_187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        if(s.length() < 10){
            return ans;
        }
        Set<String> hashMap = new HashSet<>();
        Set<String> set = new HashSet<>();
        int begin = 0,end = 10;
        hashMap.add(s.substring(begin,end));
        end++;
        for(;end <= s.length();end++,begin++){
            if(set.contains(s.substring(begin,end))){
                continue;
            }
            else{
                if(hashMap.contains(s.substring(begin,end))){
                    set.add(s.substring(begin,end));
                    hashMap.remove(s.substring(begin,end));
                }
                else{
                    hashMap.add(s.substring(begin,end));
                }
            }
        }
        for (String key: set
             ) {
            ans.add(key);
        }
        return ans;
    }

    private String getSequence(long key) {
        StringBuffer sb = new StringBuffer();
        while(key > 0){
            char c = 'A';
            if(key % 10 == 9){
                c = 'T';
            }
            else{
                c += key % 10 -1;
            }
            sb.append(c);
            key /= 10;
        }
        return sb.toString();
    }

    public static void main(String[] args){
        new D_187().findRepeatedDnaSequences("AAAAAAAAAA");
    }
}
