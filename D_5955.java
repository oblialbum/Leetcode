package com.fengtin.LeetCode;

public class D_5955 {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int[] f = new int[2 * k + 1];
        int min = startPos - k,n = fruits.length;
        for (int i = 0; i < n; i++) {
            if(fruits[i][0] >= min && fruits[i][0] <= startPos + k){
                f[fruits[i][0] - min] = fruits[i][1];
            }
        }
        int max = 0,sum = 0;
        for (int i = 0; i <= k; i++) {
            sum += f[i];
        }
        max = Math.max(max,sum);
        int left = 0,right = k;
        while (left < k){
            right ++;
            left += 2;
            sum += f[right];
            sum -= f[left - 1];
            sum -= f[left - 2];
            max = Math.max(sum,max);
        }
        sum = 0;
        for (int i = k; i <= 2 * k; i++) {
            sum += f[i];
        }
        max = Math.max(sum,max);
        left = k;
        right = 2 * k;
        while (right > k){
            left--;
            right -= 2;
            sum += f[left];
            sum -= f[right + 1];
            sum -= f[right + 2];
            max = Math.max(sum,max);
        }
        return max;
    }

    public static void main(String[] args) {
        new D_5955().maxTotalFruits(new int[][]{{200000,10000}},0,200000);
    }
}
