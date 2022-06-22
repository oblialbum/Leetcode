package com.fengtin.LeetCode;

public class D_396 {
    /**
     * 旋转 = 右移
     * 移动一次，计算和，2n的复杂度。
     * 一共N*N的复杂度，超了。
     * 0 a0,1 a1,...,(n-1)an-1
     * 1 a0,...,n-1 an-2,0 an-1
     * 2 a0,...,n-1 an-3,0 an-2,1 an-1;
     * f(1) = f(0) + sum(0,n-2) - (n - 1)an-1;
     * f(2) = f(1) +sum(0,n-3) - (n - 1) an- 2 + an-1;
     * @param nums
     * @return
     */
    public int maxRotateFunction(int[] nums) {
        int res = 0,n = nums.length,sum = 0 , f = 0;
        for (int i = 0; i < n; i++) {
            res += i * nums[i];
            sum += nums[i];
        }
        f = res;
        for (int i = 1; i <= n - 1; i++) {
            f = f + sum - n * nums[n - i];
            res = Math.max(f,res);
        }
        return res;
    }

    public static void main(String[] args) {
        new D_396().maxRotateFunction(new int[]{4,3,2,6});
    }
}
