package com.fengtin.LeetCode;

public class D_367 {
    public boolean isPerfectSquare(int num) {
        if(num == 0 || num == 1){
            return true;
        }
        long left = 1,right = num;
        while(left < right){
            long mid = left + (right - left) / 2;
            if(mid * mid == num){
                return true;
            }
            if(mid * mid > num){
                right = mid - 1;
            }
            if(mid * mid < num){
                left = mid + 1;
            }
        }

        return left*left == num;
    }

    public static void main(String[] args){
        new D_367().isPerfectSquare(3456);
    }
}
