package com.fengtin.LeetCode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class D_950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        int[] res = new int[n];
        Deque<Integer> idx = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            idx.add(i);
        }
        for (int card:deck
             ) {
            res[idx.pollFirst()] = card;
            if (!idx.isEmpty()){
                idx.add(idx.pollFirst());
            }
        }
        return res;
    }
}
