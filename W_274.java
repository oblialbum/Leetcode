package com.fengtin.LeetCode;

import java.util.Arrays;

public class W_274 {
    public boolean checkString(String s) {
        int a = -1,b = 1000;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a'){
                a = i;
            }
            if (s.charAt(i) == 'b' && b== 1000){
                b =i;
            }
        }
        return a < b;
    }
    public int numberOfBeams(String[] bank) {
        int res = 0;
        int m = bank.length,n = bank[0].length();
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (bank[i].charAt(j) == '1'){
                    nums[i]++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (nums[i] == 0){
                continue;
            }
            for (int j = i+1; j < m; j++) {
                if (nums[j] != 0){
                    res += nums[i] * nums[j];
                    break;
                }
            }
        }
        return res;
    }

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long max = mass;
        for (int asteroid:asteroids
             ) {
            if (max < asteroid){
                System.out.println(max);
                return false;
            }
            mass += asteroid;
        }
        return true;
    }


}
