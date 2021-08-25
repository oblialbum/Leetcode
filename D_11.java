package com.fengtin.LeetCode;

public class D_11 {
    private static int maxArea(int[] height) {
        int area = 0;
        int n = height.length;
        for (int i = 0, j = n - 1; i <= j; ) {
            area = area(height, i, j) > area ? area(height, i, j) : area;
            if (height[i] >= height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return area;
    }

    private static int area(int[] height, int begin, int end) {
        return Math.min(height[begin], height[end]) * (end - begin);
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
