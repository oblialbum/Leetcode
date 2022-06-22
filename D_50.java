package com.fengtin.LeetCode;

public class D_50 {
    /**
     * 将n表示为二进制数，x的n次方就是对应的结果。
     * eg..pow(2，10)
     * 10 = 1010； pow(2,10) = pow(2 ,pow(2,1)) * pow(2 , 2(2,3));
     */
    int[] binary ;
    public double myPow(double x, int n) {
        getBinary(n);
        double ans = binary[0] == 0? 1: x;
        for(int i = 1; i < binary.length; i++){
            x *= x;
            if(binary[i] == 0){
                continue;
            }
            ans *= x;

        }
        return  n > 0 ? ans : 1 / ans;
    }

    private void getBinary(int n) {
        binary = new int[32];
        int index = 0;
        while(n != 0){
            binary[index++] = n % 2;
            n/=2;
        }
    }

    public static void main(String[] args){
        System.out.println(new D_50().myPow(34.00515 ,-3));
    }
}
