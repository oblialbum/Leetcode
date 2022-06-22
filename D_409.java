package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class D_409 {
    public int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int ans = 0;
        for (char c: s.toCharArray()
             ) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (char key: map.keySet()
             ) {
            int v = map.get(key) / 2 * 2;
            ans += v;

            if(map.get(key) % 2 == 1 && ans % 2 == 0){
                ans++;
            }
        }
        return ans;
    }
}
