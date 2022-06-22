package com.fengtin.LeetCode;

public class D_806 {
    public int[] numberOfLines(int[] widths, String s) {
        int curCount = 0;
        int ans = 1;
        for(int i = 0;i < s.length();i++){
            curCount += widths[s.charAt(i) - 'a'];
            if(curCount > 100){
                i--;
                ans++;
                curCount = 0;
            }
        }
        return new int[]{ans,curCount};
    }
}
