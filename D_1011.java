package com.fengtin.LeetCode;

public class D_1011 {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0,right = 0;
        for (int i = 0; i < weights.length; i++) {
            left = Math.max(weights[i],left);
            right += weights[i];
        }
        int res = right;
        while (left <= right){
            int mid = (left + right) >> 1;
            if (ship(weights,days,mid)){
                res = Math.min(res,mid);
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }

    private boolean ship(int[] weights, int days, int load) {
        for (int i = 0; i < weights.length;) {
            int temp = load;
            while (temp > 0 && i < weights.length){
                temp -= weights[i];
                i++;
            }
            if (temp < 0){
                i--;
            }
            days--;
        }
        return days >= 0;
    }
}
