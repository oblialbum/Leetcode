package com.fengtin.LeetCode;

public class D_1616 {
    public boolean checkPalindromeFormation(String a, String b) {
        boolean res = false;
        int n = a.length();
        if (isHuiWen(a) || isHuiWen(b)){
            return true;
        }
        for (int i = 0; i < n; i++) {
            String aPrefix = a.substring(0,i + 1);
            String aSuffix = a.substring(i+1);
            String bPrefix = b.substring(0,i+1);
            String bSuffix = b.substring(i+1);
            if (isHuiWen(aPrefix + bSuffix) || isHuiWen(bPrefix + aSuffix)){
                res = true;
            }
            if (res){
                break;
            }
        }
        return res;
    }

    private boolean isHuiWen(String a) {
        for (int i = 0,j = a.length() - 1; i <= j ; i++,j--) {
            if (a.charAt(i) != a.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
