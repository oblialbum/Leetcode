package com.fengtin.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class D_1980 {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> set = new HashSet<>();
        for (String num:nums
             ) {
            set.add(num);
        }
        for (int i = 0; i < 1 << n; i++) {
            StringBuilder sb = new StringBuilder();
            int temp = i;
            while (sb.length() < n){
                sb.append(temp % 2);
                temp /= 2;
            }
            sb.reverse();
            if (!set.contains(sb.toString())){
                return sb.toString();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        new D_1980().findDifferentBinaryString(new String[]{"00","01"});
    }
}
