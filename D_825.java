package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_825 {
    public int numFriendRequests(int[] ages) {
        int cnt = 0, n = ages.length, min = 0, max = 0;
        Arrays.sort(ages);
        for (int age:ages
             ) {
            if (age < 15){
                continue;
            }
            while (ages[min] <= 0.5 * age + 7){
                ++min;
            }
            while (max + 1 < n && ages[max + 1] <= age){
                ++max;
            }
            cnt += max - min;
        }
        return cnt;
    }

    public static void main(String[] args) {
        new D_825().numFriendRequests(new int[]{20,30,100,110,120});
    }
}
