package com.fengtin.LeetCode;

public class D_278 {
    boolean[] badBersion = new boolean[6];
    public int firstBadVersion(int n) {
        badBersion[1] = badBersion[2] = badBersion[3] = false;
        badBersion[4] = badBersion[5] = true;
        if(n == 1){
            return 1;
        }
        int left = 1,right = n,mid;
        while(left < right){
            mid = left + (right - left) / 2;
            if(isBadVersion(mid)){
                right = mid;
            }
            if(!isBadVersion(mid)){
                left = mid + 1;
            }
        }
        return  left;
    }

    public boolean isBadVersion(int version){
        return badBersion[version];
    }
    public static void main(String[] args){
        new D_278().firstBadVersion(5);
    }
}
