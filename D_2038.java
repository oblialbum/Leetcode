package com.fengtin.LeetCode;

public class D_2038 {
    public boolean winnerOfGame(String colors) {
        if (colors.length() < 3){
            return false;
        }
        int a = getNums(colors,'A'),b = getNums(colors,'B');
        return a > b;
    }

    private int getNums(String colors, char a) {
        int res = 0;
        for (int i = 1; i < colors.length() - 1; i++) {
            if (colors.charAt(i) == a && colors.charAt(i - 1) == a && colors.charAt(i + 1) == a){
                res++;
            }
        }
        return res;
    }
}
