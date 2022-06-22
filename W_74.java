package com.fengtin.LeetCode;

import java.util.PriorityQueue;

public class W_74 {
    public boolean divideArray(int[] nums) {
        boolean res = true;
        int[] temp = new int[501];
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]]++;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] % 2 == 1){
                return false;
            }
        }
        return res;
    }
    //first,second相同.
    public long maximumSubsequenceCount(String text, String pattern) {
        if (pattern.charAt(0) == pattern.charAt(1)){
            return anotherMethod(text, pattern.charAt(0));
        }
        long res = 0;
        int n = text.length();
        char first = pattern.charAt(0),second = pattern.charAt(1);
        int[] numA = new int[n];
        int[] numB = new int[n];
        if (text.charAt(n - 1) == first){
            numA[n - 1] = 1;
        }
        if (text.charAt(n - 1) == second){
            numB[n - 1] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (text.charAt(i) == first){
                numA[i] = numA[i + 1] + 1;
            }
            else{
                numA[i] = numA[i + 1];
            }
            if (text.charAt(i) == second){
                numB[i] = numB[i + 1] + 1;
            }
            else{
                numB[i] = numB[i + 1];
            }
        }
        for (int i = 0; i < n; i++) {
            if (text.charAt(i) == first){
               res += numB[i];
            }
        }
        /**
         * 当前插入位置：[0,n-1]。
         */
        int max = 0;
        //最后一个位置。
        max = Math.max(max,Math.max(numA[0],numB[0]));
        return res + max;
    }

    private long anotherMethod(String text, char c) {
        long res = 0,num = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == c){
                num++;
            }
        }
        res = (num - 1) * num /2;
        res += num;
        return res;
    }

    public int halveArray(int[] nums) {
        int res = 0,n = nums.length;
        double target = 0;
        PriorityQueue<Double> max = new PriorityQueue<>((o1, o2) -> {
            if (o1 < o2){
                return 1;
            }
            if (o1 > o2){
                return -1;
            }
            return 0;
        });
        for (int i = 0; i < n; i++) {
            target += nums[i];
            max.add((double) nums[i]);
        }
        target /= 2;
        double cur = 0;
        while (cur < target){
            double num = max.poll();
            cur += num /2;
            max.add(num / 2);
            res++;
        }
        return res;
    }

    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int n = floor.length();
        int[][] dp = new int[numCarpets + 1][n];
        dp[0][0] = floor.charAt(0) % 2;
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + floor.charAt(i) % 2;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = carpetLen; j < n; j++) {
                //是否用第I个毛毯覆盖第J个地板。覆盖，不覆盖。
                dp[i][j] = Math.min(dp[i - 1][j - carpetLen],dp[i][j - 1] + floor.charAt(j) % 2);
            }
        }
        return dp[numCarpets][n - 1];
    }
    private static class Node {
        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        int idx;
        int value;

        @Override
        public int hashCode() {
            return idx * 7 + value * 13;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Node){
                return ((Node) obj).value == value && ((Node) obj).idx == idx;
            }
            return false;
        }

    }


    public static void main(String[] args) {
        new W_74().minimumWhiteTiles("10110101",2,2);
    }
}
