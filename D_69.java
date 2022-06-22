package com.fengtin.LeetCode;

public class D_69 {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        if(x < 4){
            return 1;
        }
        long ans = 2;
        long pre = 1;
        while(ans * ans < x){
            pre = ans;
            ans *= ans;
        }
        while(pre <= ans){
            long mid = pre + (ans - pre) / 2;
            if(mid * mid > x){
                ans = mid - 1;
            }
            if(mid * mid == x){
                ans = mid;
                break;
            }
            if(mid * mid < x){
                pre = mid + 1;
            }
        }
        return (int)ans;
    }
    public static void main(String[] args){
        D_69 test = new D_69();
        test.mySqrt(65589);
        for(int i = 0;i < Integer.MAX_VALUE;i++){
            if(test.mySqrt(i) != (int)Math.pow(i,0.5)){
                System.out.println(i +"false");
            }
        }

    }
}
