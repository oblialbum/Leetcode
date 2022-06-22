package com.fengtin.LeetCode;

public class D_165 {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        for (int i = 0; i < s1.length && i < s2.length; i++) {
            int first = Integer.parseInt(s1[i]);
            int second = Integer.parseInt(s2[i]);
            if(first != second){
                return first - second;
            }
        }
        if(s1.length == s2.length){
            return 0;
        }
        int min = Math.min(s2.length,s1.length);
        if(s2.length > s1.length){
            for (int i = min; i < s2.length; i++) {
                int second = Integer.parseInt(s2[i]);
                if(second != 0){
                    return - second;
                }
            }
        }
        else{
            for (int i = min; i < s1.length; i++) {
                int first = Integer.parseInt(s1[i]);
                if(first != 0){
                    return first;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        for (String s:"0.1.1".split(".")
             ) {
            System.out.println(s);
        }
        //new D_165().compareVersion("0.1","1.1");
    }
}
