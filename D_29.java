package com.fengtin.LeetCode;

public class D_29 {
    double ans;

    /**
     * 除法的结果截取小数部分，所以dividend > divisor。
     * 很慢，时间复杂度时dividend / divisor.
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if(dividend == 0){
            return 0;
        }
        double i = dividend;
        double j = divisor;
        i = Math.abs(i);
        j = Math.abs(j);
        if(i < j){
            return 0;
        }
        int symbol = 1;
        if((dividend < 0 && divisor >0) ||(dividend > 0 && divisor < 0)){
            symbol = -1;
        }
        double sum = j;
        double times = 1;

        while(i >= 0) {
            while (sum + sum <= i) {
                sum += sum;
                times += times;
            }
            i -= sum;
            sum = j;
            ans += times;
            times = 1;
        }
        ans -= 1;
        ans *= symbol;
        if(ans  > Integer.MAX_VALUE || ans < Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)ans;
    }

    public static void main(String[] args){
        System.out.println(new D_29().divide(Integer.MIN_VALUE,-1));
    }
}
