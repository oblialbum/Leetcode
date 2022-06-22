package com.fengtin.LeetCode;

public class D_717 {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        for (int i = 0; i < n;) {
            if (bits[i] == 0){
                i++;
            }else{
                i += 2;
            }
            if (i == n - 1){
                return true;
            }
        }
        return false;
    }
}
