package com.fengtin.LeetCode;

public class D_392 {
    public boolean isSubsequence(String s, String t) {
        int index1 = 0,index2 = 0;
        while(index1 < t.length()){
            if(t.charAt(index1) == s.charAt(index2)){
                index2++;
            }
            if(index2 ==s.length()){
                return true;
            }
            index1++;
        }
        return false;
    }

    public static void main(String[] args){
        new D_392().isSubsequence("abc","ahbgdc");
    }
}
