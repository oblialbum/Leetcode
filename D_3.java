package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王鑫
 */
public class D_3 {
    /**
     * @param s 求字符串的最长无重复字串长度。
     * @return 最长无重复字串长度。
     * time :8ms.
     */
    private static int lengthOfLongestSubstring(String s) {
        int subLength = 0;
        //前俩位为最长无重复字串的开始和结束位置，第三位为长度。
        int[] info = new int[]{0, 0, 0};
        Map<Character, Integer> hashtable = new HashMap<>();
        int i = 0, j = 0;
        for (; j < s.length(); ) {
            if (hashtable.containsKey(s.charAt(j))) {
                if ((j - i) > info[2]) {
                    info[0] = i;
                    info[1] = j;
                    info[2] = j - i;
                }
                int k = i;
                i = hashtable.get(s.charAt(j)) + 1;
                /**
                 * 还可以优化，无需删除，直接取i为hashtable中对应值最大的一个。
                 */
                for (; k < i; k++) {
                    hashtable.remove(s.charAt(k));
                }
                continue;
            } else {
                hashtable.put(s.charAt(j), j);
            }
            j++;
        }
        if (j == s.length()) {
            if ((j - i) > info[2]) {
                info[0] = i;
                info[1] = j;
                info[2] = j - i;
            }
            hashtable.clear();
        }
        return info[2];
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}

