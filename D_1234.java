package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class D_1234 {
    /**
     * 看成循环字符串，包含<=1/4的最长子串。
     * slide window,退出条件：start = s.len - 1 && start要继续前进了。
     * @param s
     * @return
     */
    public int balancedString(String s) {
        int n = s.length(),target = s.length() / 4;
        int start = 0,end = 0,len = 0;
        Map<Character,Integer> map = new HashMap<>(8);
        boolean flag = false;
        while (true){
            map.put(s.charAt(end),map.getOrDefault(s.charAt(end),0) + 1);
            while (move(map,target)){
                map.put(s.charAt(start),map.get(s.charAt(start)) - 1);
                start++;
                if (start == n){
                    flag = true;
                    break;
                }
            }
            end++;
            end %= n;
            if (end == start){
                return 0;
            }
            if (start == 0){
                len = Math.max(len,end);
            }else if(start > end){
                len = Math.max(len,end -start + n);
            }
            if (flag){
                break;
            }
        }
        return n - len;
    }

    private boolean move( Map<Character, Integer> map, int max) {
        for (Map.Entry<Character,Integer> entry:map.entrySet()
        ) {
            if (entry.getValue() > max){
                return true;
            }
        }
        return false;
    }

}
