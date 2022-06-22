package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res,n = heaters.length,idx,insert,p = 0;
        int[] needs = new int[houses.length];
        for (int house:houses
             ) {
            idx = Arrays.binarySearch(heaters,house);
            res = 0;
            if(idx < 0){
                insert = - idx - 1;
                if(insert == 0){
                    res = Math.abs(house - heaters[0]);
                }else if (insert == n){
                    res = Math.abs(house - heaters[n - 1]);
                }else{
                    res = Math.min(house - heaters[insert - 1],heaters[insert] - house);
                }
            }
            needs[p++] = res;
        }
        res = needs[0];
        for (int need:needs
             ) {
            res = Math.max(res,need);
        }
        return res;
    }
}
