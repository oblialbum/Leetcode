package com.fengtin.LeetCode;

public class D_5 {
    private static boolean isHuiwenchuan(char[] a, int i, int j) {
        boolean flag = true;
        for (; i <= j; i++, j--) {
            if (a[i] != a[j]) {
                flag = false;
                break;
            }

        }
        return flag;
    }

    /*
    public static String longestPalindrome(String s){
        char[] a= s.toCharArray();
        int begin =0,end = 0;
        int i =0,j,maxLen = 0;
        for(;i < s.length();i++){
            for(j = i;j < s.length();j++){
                if(a[i] == a[j]) {
                    if (isHuiwenchuan(a, i, j) && (j - i + 1) > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(begin,end+1);
    }

     */
    private static String longestPalindrome(String s) {
        char[] a = s.toCharArray();
        int maxLen = 0, begin = 0, end = 1;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == a[i + 1]) {
                int[] info = getMaxLenOfHuiwen(a, i, i + 1);
                int cur = info[1] - info[0];
                if (cur > maxLen) {
                    end = info[1];
                    begin = info[0];
                    maxLen = cur;
                }
            }
            int[] info = getMaxLenOfHuiwen(a, i, i);
            int cur = info[1] - info[0];
            if (cur > maxLen) {
                end = info[1];
                begin = info[0];
                maxLen = cur;
            }
        }
        return s.substring(begin, end);
    }

    private static int[] getMaxLenOfHuiwen(char[] a, int i, int j) {
        int len = 0;
        for (; i >= 0 && j < a.length; i--, j++) {
            if (a[i] != a[j]) {
                break;
            }
        }
        int[] info = new int[2];
        info[0] = i + 1;
        info[1] = j;
        return info;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccc"));
    }
}
