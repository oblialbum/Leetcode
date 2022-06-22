package com.fengtin.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class W_80 {
    public boolean strongPasswordCheckerII(String password) {
        char[] array = "!@#$%^&*()-+".toCharArray();
        Set<Character> set = new HashSet<>();
        for (char a:array
             ) {
            set.add(a);
        }
        int n = password.length();
        if (n < 8){
            return false;
        }
        boolean flag1 = false,flag2 = false,flag3 = false,flag4 = false;
        for (int i = 0; i < n; i++) {
            char c = password.charAt(i);
            if (i > 0 && c == password.charAt(i - 1)){
                return false;
            }
            if (Character.isDigit(c)){
                flag3 = true;
            }
            if (Character.isUpperCase(c)){
                flag2 = true;
            }
            if (Character.isLowerCase(c)){
                flag1 = true;
            }
            if (set.contains(c)){
                flag4 = true;
            }
        }
        return flag1 && flag2 && flag3 && flag4;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length,m = potions.length;
        int[] res = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            int idx = search(spells[i],potions,success);
            if (idx == -1){
                continue;
            }
            res[i] = m - idx;
        }
        return res;
    }

    private int search(long spell, int[] potions, long success) {
        if (spell * potions[potions.length - 1] < success){
            return -1;
        }
        int left = 0,right = potions.length - 1;
        while (left < right){
            int mid = (left + right) / 2;
            if (spell * potions[mid] < success){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        return false;
    }

    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        long res = nums[0] < k ? 1 : 0;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
            if (nums[i] < k){
                res++;
            }
        }
        for (int i = 0; i < n - 1; i++) {
//            大于等于的最小下标。
            if (nums[i] >= k){
                continue;
            }
            int low = i,high = n - 1;
            if ((high - low + 1) * (prefix[high] - (low == 0 ? 0: prefix[low - 1])) < k){
                res += high - low;
                continue;
            }
            while (low < high){
                int mid = (low + high) / 2;
                long cur = (mid - i +1) * ((long)prefix[mid] - (i == 0 ? 0: prefix[i - 1]));
                if (cur < k){
                    low = mid + 1;
                }else{
                    high = mid;
                }
            }
            low--;
            res += low - i;
        }
        return res;
    }

    public static void main(String[] args) {
        new W_80() .countSubarrays(new int[]{5,2,6,8,9,7},50);
    }
}
