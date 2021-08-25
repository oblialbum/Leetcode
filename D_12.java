package com.fengtin.LeetCode;

public class D_12 {
    private static String intToRoman(int num) {
        String prefix = "";
        if (num > 1000) {
            int i = num / 1000;
            while (i > 0) {
                prefix += 'M';
                i--;
            }
            num %= 1000;
        }
        int n = countLength(num);
        int[] nums = new int[]{0, 1, 5, 10, 50, 100, 500, 1000};
        char[] roman = "OIVXLCDM".toCharArray();
        String s = "";
        int temp;
        while (n > 0) {
            temp = num / nums[n - 1];
            num %= nums[n - 1];
            if (temp == 4) {
                s += "" + roman[n - 1] + roman[n] + "";
                n -= 2;
                continue;
            }
            if (temp == 9) {
                s += "" + roman[n - 1] + roman[n + 1];
                n -= 2;
                continue;
            }
            if (temp >= 5) {
                s += roman[n] + "";
                temp -= 5;
            }
            while (temp > 0) {
                s += roman[n - 1] + "";
                temp--;
            }
            n -= 2;
        }
        s = prefix + s;

        return s;
    }

    private static int countLength(int num) {
        if (num >= 1000) {
            return 8;
        } else if (num >= 100) {
            return 6;
        } else if (num >= 10) {
            return 4;
        } else {
            return 2;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(intToRoman(1999));
    }
}
