package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_1477 {
    /**
     * dp[i]:在i(包含)之后的和为target的子数组的最短长度,1e5+1表示无。
     * @param arr
     * @param target
     * @return
     */
    public int minSumOfLengths(int[] arr, int target) {
        int res = Integer.MAX_VALUE,n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, (int) (1e5+1));
        int left = n - 1,right = n - 1,sum = 0;
        while (left >= 0){
            sum += arr[left];
            while (sum > target){
                sum -= arr[right];
                right--;
            }
            if (sum == target){
                dp[left] = right - left + 1;
                sum -= arr[right];
                right--;
            }
            left--;
        }
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = Math.min(dp[i],dp[i + 1]);
        }
        left = 0;
        right = 0;
        sum = 0;
        while (right < n){
            sum += arr[right];
            while (sum > target){
                sum -= arr[left];
                left++;
            }
            if (sum == target){
                if (right == n - 1){
                    break;
                }
                if (dp[right + 1] == 1e5 + 1){
                    break;
                }
                res = Math.min(right - left + 1 +dp[right + 1],res);
                sum -= arr[left];
                left++;
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        new D_1477().minSumOfLengths(new int[]{4,3,2,6,2,3,4},6);
    }
}
