package com.fengtin.LeetCode;

public class W_75 {
    public int minBitFlips(int start, int goal) {
        int[] arr1 = getArr(start),arr2 = getArr(goal);
        int res = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]){
                res++;
            }
        }
        return res;
    }

    private int[] getArr(int start) {
        int[] ans = new int[32];
        int idx = 31;
        while (start > 0){
            ans[idx--] = start % 2;
            start /= 2;
        }
        return ans;
    }

    public int triangularSum(int[] nums) {
        int n = nums.length,idx = 1;
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[0][i] = nums[i];
        }
        while (n > 1){
            for (int i = 0; i < n - 1; i++) {
                arr[idx][i] = (arr[idx - 1][i] + arr[idx - 1][i + 1]) % 10;
            }
            idx++;
            n--;
        }
        return arr[nums.length - 1][0];
    }

    public long numberOfWays(String s) {
        int n = s.length();
        long res = 0;
        long[][] right = new long[2][n],left = new long[2][n];
        int num0 = 0,num1 = 0;
        char c ;
        for (int i = n - 1; i >= 0; i--) {
            c = s.charAt(i);
            if (i != n - 1){
                right[0][i] = num0;
                right[1][i] = num1;
            }
            if (c == '0'){
                num0++;
            }else{
                num1++;
            }
        }
        num0 = 0;
        num1 = 0;
        for (int i = 0; i < n; i++) {
            c = s.charAt(i);
            if (i != 0){
                left[0][i] = num0;
                left[1][i] = num1;
            }
            if (c == '0'){
                num0++;
            }else{
                num1++;
            }
        }
        for (int i = 0; i < n; i++) {
            c = s.charAt(i);
            if (c == '0'){
                res += left[1][i] * right[1][i];
            }else{
                res += left[0][i] * right[0][i];
            }
        }
        return res;
    }

    static final int N = (int) 1e5+10;
    static long[] h = new long[N];
    static long[] p = new long[N];
    static final int P = 131;
    public long get(int l, int r) {
        return h[r + 1] - h[l] * p[r - l + 1];
    }
    public long sumScores(String s) {
        p[0] = 1;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            h[i + 1] = h[i] * P + s.charAt(i);
            p[i + 1] = p[i] * P;
        }
        long score = n;
        for (int i = 1; i < n; ++i) {
            int l = i, r = n - 1;
            while (l <= r) {
                int mid = l + r >> 1;
                if (check(i, mid)) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            score += (r - i + 1);
        }
        return score;
    }
    public boolean check(int l, int r) {
        return get(0, r - l) == get(l, r);
    }

    public static void main(String[] args) {
        new W_75().sumScores("azbazbzaz");
    }
}
