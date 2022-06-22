package com.fengtin.LeetCode;

public class D_941 {
    /**
     * 0 1 2 3 4
     * 0 2 1 4 3
     * D,(idx,idx + 1) reverse
     * 0 1 2 3
     * 2 1 0 3
     * @param s
     * @return
     */
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] res = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            res[i] = i;
        }
        for (int left = 0; left < n; left++) {
            if (s.charAt(left) != 'D'){
                continue;
            }
            for (int right = left;; right++) {
                if (right == n || s.charAt(right) != 'D'){
                    reverse(res,left,right);
                    left = right;
                    break;
                }
            }
        }
        return res;
    }

    private void reverse(int[] res, int left, int right) {
        for (int i = left,j = right; i <= j; i++,j--) {
            int temp = res[i];
            res[i] = res[j];
            res[j] = temp;
        }
    }

    public static void main(String[] args) {
        new D_941().diStringMatch("DDI");
    }
}
