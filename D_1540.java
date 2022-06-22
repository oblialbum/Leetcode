package com.fengtin.LeetCode;

public class D_1540 {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()){
            return false;
        }
        int n = s.length(),operation,next;
        char c1 ,c2;
        int[] operations = new int[26];
        for (int i = 0; i < n; i++) {
            c1 = s.charAt(i);
            c2 = t.charAt(i);
            if (c1 != c2){
                operation = (c2 -c1 + 26) % 26;
                next = operations[operation];
                if (operation + 26*next > k){
                    return false;
                }
                operations[operation]++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new D_1540().canConvertString("input","ouput",9);
    }
}
