package com.fengtin.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class D_821 {
    public int[] shortestToChar(String s, char c) {
        int[] res = new int[s.length()];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c){
                list.add(i);
            }
        }
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c){
                res[i] = 0;
                cur++;
            }else{
                if (cur == 0){
                    res[i] = list.get(cur) - i;
                }else{
                    if (cur == list.size()){
                        res[i] = i - list.get(cur - 1);
                    }else {
                        res[i] = Math.min(list.get(cur) - i, i - list.get(cur - 1));

                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new D_821().shortestToChar("loveleetcodecxdfghfexfseesas",'e');
    }
}
