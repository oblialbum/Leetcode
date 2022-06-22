package com.fengtin.LeetCode;

public class D_875 {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1,r = 10000;
        while (l < r){
            int mid = l + (r - l) / 2;
            long count = 0;
            for (int pile:piles
                 ) {
                count += (pile - 1) / mid + 1;
            }
            if(count <= h){
                r = mid;
            }
            else{
              l = mid + 1;
            }
        }
        return l;
    }
}
