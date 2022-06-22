package com.fengtin.LeetCode;

import java.util.Arrays;

public class W_71 {
    public int minimumSum(int num) {
        int res = 0;
        int[] nums = new int[10];
        while (num > 0){
            nums[num % 10]++;
            num /= 10;
        }
        if (nums[0] == 3){
            for (int i = 1; i < 10; i++) {
                if (nums[i]!=0){
                    res += i;
                    break;
                }
            }
            return res;
        }
        if (nums[0] == 2){
            for (int i = 0; i < 10; i++) {
                while (nums[i]!=0){
                    res += i;
                    nums[i]--;
                }
            }
            return res;
        }
        if (nums[0] == 1){
            int flag = 0;
            for (int i = 1; i < 10; i++) {
                while (nums[i]!=0 && flag != 2){
                    res *= 10;
                    res += i;
                    flag++;
                    nums[i]--;
                }
            }
            for (int i = 0; i < 10; i++) {
                if(nums[i]!=0){
                    res += i;
                }
            }
            return res;
        }
        if (nums[0] == 0){
            int flag = 0;
            for (int i = 0; i < 10; i++) {
                while (nums[i] != 0){
                    if (flag != 2){
                        flag++;
                        res+=i;
                        nums[i]--;
                    }else{
                        break;
                    }
                }
            }
            res *= 10;
            for (int i = 9; i >0 ; i--) {
                while (nums[i] != 0){
                    res+=i;
                    nums[i]--;
                }
            }
            return res;
        }
        return res;
    }

    public int[] pivotArray(int[] nums, int pivot) {
        int big = 0,n = nums.length,idx1 = 0;
        for (int num:nums
             ) {
            if (num > pivot){
                big++;
            }
        }
        int[] res = new int[n];
        Arrays.fill(res,pivot);
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot){
                res[idx1++] = nums[i];
            }
            if (nums[i] > pivot){
                res[n - big--] = nums[i];
            }
        }
        return res;
    }

    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int min = 0,second = 0;
        if (targetSeconds >= 6000){
            min = 99;
            second = targetSeconds - 99 * 60;
        }else {
            min = targetSeconds / 60;
            second = targetSeconds % 60;
        }
        int res1 = getTime(min,second,startAt,pushCost,moveCost);
        if (second + 60 < 100 && min > 0){
            min -= 1;
            second += 60;
        }
        int res2 = getTime(min,second,startAt,pushCost,moveCost);
        return Math.min(res1,res2);
    }

    private int getTime(int min, int second,int startAt,int pushCost,int moveCost) {
        int res1 = 0;
        int[] nums = new int[4];
        if (min == 0){
            nums[0] = 0;
        }
        else if (min < 10){
            nums[1] = min;
        }
        else{
            nums[0] = min /10;
            nums[1] = min % 10;
        }
        if (second == 0){
            nums[2] = 0;
        }
        else if (second < 10){
            nums[3] = second;
        }
        else{
            nums[2] = second /10;
            nums[3] = second % 10;
        }
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0 && flag){
                continue;
            }
            if (nums[i] == startAt){
                res1 += pushCost;
            }else{
                res1 += pushCost + moveCost;
                startAt = nums[i];
            }
            flag = false;
        }
        return res1;
    }

    public static void main(String[] args) {
        new W_71().minCostSetTime(1,2,1,6039);
    }
}
