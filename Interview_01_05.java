package com.fengtin.LeetCode;

public class Interview_01_05 {
    public boolean oneEditAway(String first, String second) {
        if (first.equals(second)){
            return true;
        }
        int m = first.length();
        int n = second.length();
        if (Math.abs(m - n) > 1){
            return false;
        }
        if (m == n){
            return isOneChange0(first,second);
        }else{
            if (m > n){
                return isOneChange1(second,first);
            }
            return isOneChange1(first,second);
        }
    }

    private boolean isOneChange1(String first, String second) {
        for (int i = 0,j = 0; i < first.length() && j < second.length();) {
            if (first.charAt(i) == second.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
            if (j - i > 1){
                return false;
            }
        }
        return true;
    }

    private boolean isOneChange0(String first, String second) {
        int cnt = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)){
                cnt++;
            }
        }
        return cnt == 1;
    }

    public static void main(String[] args) {
        new Interview_01_05().oneEditAway("teacher","taches");
    }
}
