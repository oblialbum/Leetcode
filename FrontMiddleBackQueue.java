package com.fengtin.LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class FrontMiddleBackQueue {
    Deque<Integer> front ,back;

    public FrontMiddleBackQueue() {
        front = new ArrayDeque<>();
        back = new ArrayDeque<>();
    }

    public void pushFront(int val) {
        front.addFirst(val);
    }

    public void pushMiddle(int val) {
        while (front.size() < back.size()){
            front.add(back.poll());
        }
        while (front.size() > back.size()){
            back.addFirst(front.pollLast());
        }
        front.add(val);
    }

    public void pushBack(int val) {
        back.add(val);
    }

    public int popFront() {
        return front.size() == 0 ? (back.size() == 0 ? -1 :back.poll()):front.poll();
    }

    public int popMiddle() {
        if (front.size() == 0 && back.size() == 0){
            return -1;
        }
        while (front.size() < back.size()){
            front.add(back.poll());
        }
        while (front.size() > back.size()){
            back.addFirst(front.pollLast());
        }
        //back.size >= front.size
        if (front.size() == back.size()){
            return front.pollLast();
        }else{
            return back.poll();
        }
    }

    public int popBack() {
        return back.size() == 0 ? (front.size() == 0 ? -1:front.pollLast()): back.pollLast();
    }
}
