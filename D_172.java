package com.fengtin.LeetCode;

public class D_172 {
    /**
     * 0的产生：
     * 5 * 2m. :每有一个5，对应要有一个偶数，相乘之后带0，个数不好总结规律。
     * 10 * m. :与任意数相乘都会带0，个数为各自带0之和。
     * eg:20
     * 5,15,10,20.
     * 5*4:1;15*14:1
     * 10*9:1'20*9:1;
     *
     * 找规律失败。
     *
     * 正确的规律：每一个（5，2）都会贡献一个0，2的个数一定比5多。
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int ans = 0;
        for(int i = 5;i <= n;i += 5){
            int curNum = i;
            while(curNum % 5 == 0){
                ans++;
                curNum /= 5;
            }
        }
        return ans;
    }


    public static void main(String[] args){
        System.out.println( new D_172().trailingZeroes(10000));
    }
}
