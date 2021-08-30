package com.fengtin.LeetCode;

public class D_7 {
    double ans;

    /**
     * 先用64位存储结果，最后分符号进行判断。
     * @param x
     * @return
     */
    public int reverse(int x) {
        /**
         * 避免下面的-x超过范围。
         */
        if(x == Integer.MIN_VALUE){
            return 0;
        }
        int symbol = 1;
        if(x < 0){
            symbol = -1;
            x = -x;
        }
        for(;x != 0;x /= 10){
            int temp = x % 10;
            ans *= 10;
            ans += temp;
        }
        ans *= symbol;
        if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE){
            return 0;
        }
        return (int)ans;
    }
}
