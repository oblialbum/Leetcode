package com.fengtin.LeetCode;

public class D_1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] res = new int[queries.length];
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] ^ arr[i];
        }
        for (int i = 0; i < res.length; i++) {
            if (queries[i][1] == queries[i][0]) {
                res[i] = arr[i];
            } else {
                res[i] = prefix[queries[i][1] + 1] ^ prefix[queries[i][0]];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(4 ^ 4);
    }
}
