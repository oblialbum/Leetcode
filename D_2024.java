package com.fengtin.LeetCode;

public class D_2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(getMax(answerKey,k,'T'),getMax(answerKey,k,'F'));
    }

    private int getMax(String answerKey, int k, char ch) {
        int n = answerKey.length();
        int ans = 0;
        for (int left = 0, right = 0, sum = 0; right < n; right++) {
            sum += answerKey.charAt(right) != ch ? 1 : 0;
            while (sum > k) {
                sum -= answerKey.charAt(left++) != ch ? 1 : 0;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        new D_2024().maxConsecutiveAnswers("TTFTTTF",1);
    }
}
