package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)){
                list.add(i);
            }
        }
        return list;
    }

    private boolean isSelfDividing(int x) {
        int temp, n = x;
        while (x > 0){
            temp = x % 10;
            if (temp == 0 || n % temp != 0){
                return false;
            }
            x /= 10;
        }
        return true;
    }
}
