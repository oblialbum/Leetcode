package com.fengtin.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class D_202 {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        visited.add(n);
        while(n != 1){
            n = getSquareSum(n);
            if(visited.contains(n)){
                return false;
            }
            visited.add(n);
        }
        return true;
    }

    private int getSquareSum(int n) {
        int ans = 0;
        while (n > 0){
            ans += Math.pow(n % 10,2);
            n /= 10;
        }
        return ans;
    }

    public static void main(String[] args){
        new D_202().isHappy( 2);
    }
}
