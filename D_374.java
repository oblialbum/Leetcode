package com.fengtin.LeetCode;

public class D_374 {
    public int guessNumber(int n) {
        int left = 1,right = n;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(guess(mid) == 0){
                return  mid;
            }
            if(guess(mid) < 0){
                right = mid - 1;
            }
            if(guess(mid) > 0){
                left = mid + 1;
            }
        }
        return left;
    }
    int guess(int num){
       return -num + 923;
    }

    public static void main(String[] args){
        new D_374().guessNumber(3456);
    }
}
