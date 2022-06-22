package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_2028 {
    int[] res ;
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = (m + n) * mean - Arrays.stream(rolls).sum();
        if (sum > 6*n || sum < n){
            return new int[]{};
        }
        res = new int[n];
        Arrays.fill(res,sum / n);
        int need = sum % n,max;
        for (int i = 0; need > 0; i++) {
            max = Math.min(need,6 - res[i]);
            need -= max;
            res[i] += max;
        }
        return res;
    }


    public static void main(String[] args) {
        new D_2028().missingRolls(new int[]{1},3,1);
    }
}
