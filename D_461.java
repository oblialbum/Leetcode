package com.fengtin.LeetCode;

public class D_461 {
    public int hammingDistance(int x, int y) {
        int i ,j,ans = 0;
        while (x != 0 || y != 0){
            i = x % 2;
            j = y % 2;
            if(i != j){
                ans++;
            }
            x /= 2;
            y /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        new D_461().hammingDistance(1,4);
    }
}
