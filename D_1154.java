package com.fengtin.LeetCode;

public class D_1154 {
    public int dayOfYear(String date) {
        String[] time = date.split("-");
        int[] months = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        if (runYear(time[0])){
            months[1] += 1;
        }
        int res = 0;
        for (int i = 0; i < Integer.parseInt(time[1]) - 1; i++) {
            res += months[i];
        }
        res += Integer.parseInt(time[2]);
        return res;
    }

    private boolean runYear(String s) {
        int year = Integer.parseInt(s) ;
        if (year % 4 == 0){
            if (year % 100 == 0 && year % 400 != 0){
                return false;
            }
            return true;
        }
        return false;
    }
}
