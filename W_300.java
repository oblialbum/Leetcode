package com.fengtin.LeetCode;

import java.util.*;

public class W_300 {
    public String decodeMessage(String key, String message) {
        Map<Character,Character> map = new HashMap<>();
        Set<Character> occur = new HashSet<>();
        char begin = 'a';
        for (char c: key.toCharArray()
             ) {
            if (occur.contains(c) || c == ' '){
                continue;
            }
            occur.add(c);
            map.put(c,begin);
            if (begin == 'z'){
                break;
            }
            begin = (char)(begin + 1);
        }
        map.put(' ',' ');
        StringBuilder sb = new StringBuilder();
        for (char c: message.toCharArray()
             ) {
            sb.append(map.get(c));
        }
        return sb.toString();
    }
    int m ,n;
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        this.m = m;
        this.n = n;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i],-1);
        }
        fill(res,0,head);
        return res;
    }

    private void fill(int[][] res, int pos, ListNode head) {
        int x = 0,y = 0;
        while (head != null && pos + x < n - pos){
            res[pos][pos + x] = head.val;
            x++;
            head = head.next;
        }
        if (head == null){
            return;
        }
        y++;
        x--;
        while (head != null && pos + y < m - pos){
            res[pos + y][pos + x] = head.val;
            y++;
            head = head.next;
        }
        if (head == null){
            return;
        }
        x--;
        y--;
        while (head != null && x >= 0){
            res[pos + y][pos + x] = head.val;
            x--;
            head = head.next;
        }
        if (head == null){
            return;
        }
        y--;
        x++;
        while (head != null && y > 0){
            res[pos + y][pos + x] = head.val;
            y--;
            head = head.next;
        }
        if (head == null){
            return;
        }
        fill(res,pos + 1,head);
    }

    /**
     * 记录第一天到forget之间每一天的人数，判断转移方程。
     */
    final int mod = 1000000007;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long res = 0L;
        long[] dp = new long[forget];
        dp[0] = 1;
        int cnt = 1;
        while (cnt < n){
            long day1 = 0;
            for (int i = delay - 1; i < dp.length - 1; i++) {
                day1 += dp[i];
                day1 %= mod;
            }
            for (int i = dp.length - 1; i > 0; i--) {
                dp[i] = dp[i - 1];
            }
            dp[0] = day1;
            cnt++;
        }
        for (long l : dp) {
            res += l;
            res %= mod;
        }
        return (int)res;
    }




    public static void main(String[] args) {
//        [x + delay]分享秘密
//        [x + forget]遗忘秘密，无法开始传播。
        new W_300().peopleAwareOfSecret(4,1,3);
    }
    
}
