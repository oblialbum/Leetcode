package com.fengtin.LeetCode;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
        right = new PriorityQueue<>();
        left = new PriorityQueue<>((x, y) ->(y - x));
    }

    public void addNum(int num) {
        int s1 = left.size(),s2 = right.size();
        if(s1 == s2){
            if(right.isEmpty() ||num <= right.peek()){
                left.add(num);
            }
            else{
                left.add(right.poll());
                right.add(num);
            }
        }
        else{
            if(num >= left.peek()){
                right.add(num);
            }
            else{
                right.add(left.poll());
                left.add(num);
            }
        }
    }

    public double findMedian() {
        if(left.size() == right.size()){
            return (left.peek() + right.peek()) / 2.0;
        }
        else{
            return left.peek();
        }
    }
}
