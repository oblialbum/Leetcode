package com.fengtin.LeetCode;

public class D_400 {
    /**
     * 1-9:9
     * 10-99:90
     * 100-999:900
     * i位：Math.pow(10,i-1) * 9
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        /**
         * 第n个数是pos位数的一部分。
         */
        int pos = 1;
        while(n - Math.pow(10,pos - 1) * 9 * pos > 0){
            n -= Math.pow(10,pos - 1) * 9 * pos;
            pos++;
        }
        int target = (int) Math.pow(10,pos - 1) + (n - 1)/ pos ;
        int mod = (n - 1) % pos;
        return String.valueOf(target).charAt(mod) - '0';
    }
}
