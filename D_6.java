package com.fengtin.LeetCode;

public class D_6 {
    private static String convert(String s, int numRows) {
        String ret = "";
        int circle = 2 * (numRows - 1);
        if (numRows < 2) {
            ret = s;
        } else {
            for (int i = 0; i < numRows; i++) {
                if (i == 0 || i == numRows - 1) {
                    for (int j = 0; i + j < s.length(); j += circle) {
                        ret += s.charAt(i + j);
                    }
                } else {
                    for (int j = 0; j + circle - i < s.length() && (i + j) < s.length(); j += circle) {
                        ret += s.charAt(i + j);
                        ret += s.charAt(j + circle - i);
                    }

                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
