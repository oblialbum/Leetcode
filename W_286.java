package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class W_286 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num:nums1
             ) {
            set1.add(num);
        }
        for (int num:nums2
        ) {
            set2.add(num);
        }
        for (int num:set1
             ) {
            if (!set2.contains(num)){
                res.get(0).add(num);
            }
        }
        for (int num:set2
        ) {
            if (!set1.contains(num)){
                res.get(1).add(num);
            }
        }
        return res;
    }

    public int minDeletion(int[] nums) {
        int n = nums.length,res = 0,first = 0,second = 1;
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        while (second < n){
            if (nums[first] != nums[second]){
                second += 2;
                first = second - 1;
            }else{
                second += 1;
                res++;
            }
        }
        if ((n - res) % 2 == 1){
            res++;
        }
        return res;
    }

    public long[] kthPalindrome(int[] queries, int intLength) {
        int sum = getSum(intLength);
        long[] res = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] > sum){
                res[i] = -1;
                continue;
            }
            /**
             * 必须按照规则来获取第i个最小的数，否则超时。
             */
            res[i] = getKth(intLength,sum,queries[i]);
        }
        return res;
    }

    private long getKth(int intLength,int sum,int k) {
        int[] nums = new int[intLength];
        sum /= 9;
        int p = 0;
        while (p <= (intLength - 1)/ 2){
            if (p == 0){
                nums[p] = k /sum + 1;
            }else{
                nums[p] = k / sum;
            }
            k %= sum;
            sum /= 10;
            p++;
        }
        nums[p - 1] -= 1;
        p = (intLength - 1 )/ 2;
        while (nums[p] == -1){
            nums[p] = 9;
            nums[p - 1] -= 1;
            p--;
        }
        for (int i = 0,j = intLength - 1; i <= j; i++,j--) {
            nums[j] = nums[i];
        }
        long res = 0;
        for (int i = 0; i < intLength; i++) {
            res *= 10L;
            res += nums[i];
        }
        return res;
    }

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int m = piles.size();
        int[][] dp = new int[m+1][k+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= k; j++) {
                int sum = 0;
                for (int l = 0; l <= piles.get(i - 1).size() && l <= j; l++) {
                    dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - l] + sum);
                    if (l < piles.get(i - 1).size()){
                        sum += piles.get(i - 1).get(l);
                    }
                }
            }
        }
        return dp[m][k];
    }

    private int getSum(int intLength) {
        if (intLength % 2 == 0){
            return (int) (9 * Math.pow(10,intLength / 2 - 1));
        }else {
            return (int) (9 * Math.pow(10,intLength/2));
        }
    }


    public static void main(String[] args) {
        new W_286().minDeletion(new int[]{1,1,2,2,3,3});
    }
}
