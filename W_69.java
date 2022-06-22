package com.fengtin.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class W_69 {
    public String capitalizeTitle(String title) {
        String[] strings = title.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s: strings
             ) {
            if (s.length() <= 2){
                sb.append(s.toLowerCase());
            }else{
                char c = s.charAt(0);
                c = Character.isLowerCase(c) ? (char) (c - 32) :c;
                sb.append(c);
                sb.append(s.substring(1).toLowerCase());
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public int pairSum(ListNode head) {
        Map<Integer,Integer> map = new HashMap<>();
        ListNode p = head;
        int step = 1;
        while (p != null){
            map.put(step,p.val);
            step++;
            p = p.next;
        }
        int max = 0;
        for (int i = 1; i <= step/2; i++) {
            int cur = map.get(i) + map.get(step - i);
            max = Math.max(cur,max);
        }
        return max;
    }

    public int longestPalindrome(String[] words) {
        Map<String,Integer> diffMap = new HashMap<>();
        Map<String,Integer> sameMap = new HashMap<>();
        for (String word:words
             ) {
            if (word.charAt(0) == word.charAt(1)){
                sameMap.put(word,sameMap.getOrDefault(word,0) + 1);
            }else{
                diffMap.put(word,diffMap.getOrDefault(word,0) + 1);
            }
        }
        boolean odd = false;
        int res = 0;
        for (Map.Entry<String,Integer> entry:diffMap.entrySet()
        ) {
            int num = entry.getValue();
            String key = entry.getKey();
            char first = key.charAt(0),second = key.charAt(1);
            String reverse = new String(new char[]{second,first});
            if (diffMap.containsKey(reverse)){
                res += 2 * Math.min(num,diffMap.get(reverse));
            }
        }
        res /= 2;
        for (Map.Entry<String,Integer> entry:sameMap.entrySet()
        ) {
            int num = entry.getValue();
            if (!odd){
                res += num;
                if (num % 2 == 1){
                    odd = true;
                }
            }else{
                if (num % 2 == 1){
                    res += num - 1;
                }else{
                    res += num;
                }
            }
        }
        return res * 2;
    }
    


    public static void main(String[] args) {
        W_69 w69 = new W_69();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        w69.longestPalindrome(new String[]{"lc","cl","gg"});
    }
}
