package com.fengtin.LeetCode;

import java.util.PriorityQueue;

public class SORTracker {
    PriorityQueue<SOR> left;
    PriorityQueue<SOR> right;
    public SORTracker() {
        left = new PriorityQueue<>((x,y) ->(x.score == y.score ? x.name.compareTo(y.name):y.score - x.score));
        right = new PriorityQueue<>((x,y) ->(x.score == y.score ? y.name.compareTo(x.name):x.score - y.score));
    }

    public void add(String name, int score) {
        right.add(new SOR(score,name));
        left.add(right.poll());
    }

    public String get() {
        right.add(left.poll());
        return right.peek().name;
    }

    private class SOR{
        int score;
        String name;
        public SOR(int score,String name){
            this.name = name;
            this.score = score;
        }
    }
}
