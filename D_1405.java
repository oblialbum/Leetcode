package com.fengtin.LeetCode;

import java.util.Arrays;

public class D_1405 {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        Pair[] arr = new Pair[]{new Pair('a',a),new Pair('b',b),new Pair('c',c)};
        while (true){
            Arrays.sort(arr,(x,y) ->y.freq - x.freq);
            boolean next = false;
            for (Pair pair: arr
                 ) {
                if (pair.freq <= 0){
                    break;
                }
                int m = res.length();
                if (m >= 2 && res.charAt(m - 2) == pair.ch && res.charAt(m - 1) == pair.ch){
                    continue;
                }
                res.append(pair.ch);
                pair.freq--;
                next = true;
                break;
            }
            if (!next){
                break;
            }
        }
        return res.toString();
    }

    private class Pair{
        char ch;
        int freq;
        public Pair(char ch,int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
}
