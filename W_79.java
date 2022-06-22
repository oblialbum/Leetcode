package com.fengtin.LeetCode;

import java.util.*;

public class W_79 {
    public boolean digitCount(String num) {
        int[] cnt = new int[10];
        for (char c: num.toCharArray()
             ) {
            cnt[c - '0']++;
        }
        for (int i = 0; i < num.length(); i++) {
            if (cnt[i] != num.charAt(i)- '0'){
                return false;
            }
        }
        return true;
    }

    public String largestWordCount(String[] messages, String[] senders) {
        Map<String,Integer> map = new HashMap<>();
        int n = messages.length,max = 0;
        for (String sender:senders
             ) {
            map.put(sender,0);
        }
        for (int i = 0; i < n; i++) {
            int len = messages[i].split(" ").length;
            map.put(senders[i],map.get(senders[i]) + len);
            max = Math.max(max,map.get(senders[i]));
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max){
                res.add(entry.getKey());
            }
        }
        Collections.sort(res);
        return res.get(res.size() - 1);
    }

    public long maximumImportance(int n, int[][] roads) {
        long res = 0;
        long[] degree = new long[n];
        for (int[] road:roads
             ) {
            int from = road[0],to = road[1];
            degree[from]++;
            degree[to]++;
        }
        Arrays.sort(degree);
        for (int i = 0; i < n; i++) {
            res += (i+1) * degree[i];
        }
        return res;
    }

    public static void main(String[] args) {
        new W_79().maximumImportance(5,new int[][]{{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}});
    }
}
