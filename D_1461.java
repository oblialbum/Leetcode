package com.fengtin.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class D_1461 {
    public static void main(String[] args) {
        new D_1461().hasAllCodes("0110", 1);
    }

    /**
     * 长度为[1...k]的窗口枚举所有子串，计算子串对应的十进制数，移除对应长度set的key,判空。
     */
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < (1 << k) + k - 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        int right = k - 1, n = s.length(), sum = 0;
        for (int j = 0; j <= right; j++) {
            sum = (sum << 1) + (s.charAt(j) - '0');
        }
        while (right < n) {
            set.add(sum);
            sum %= 1 << (k - 1);
            right++;
            if (right >= n){
                break;
            }
            sum = (sum << 1) + (s.charAt(right) - '0');
        }
        return set.size()  == (1 << k);
    }
}
