package com.fengtin.LeetCode;

public class D_434 {
    public int countSegments(String s) {
        int ans = 0;
        int len = 0;
        for(int i = 0;i < s.length(); i++){
            if(s.charAt(i) != ' '){
                len++;
            }
            else {
                if(len != 0){
                    ans++;
                    len = 0;
                }
            }
        }
        ans += len == 0 ? 0 : 1;
        return ans;
    }

    public static void main(String[] args){
        new D_434().countSegments(", , , ,        a, eaefa");
    }
}
