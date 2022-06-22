package com.fengtin.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    /**
     * queue2始终只含有一个元素。
     */
    Queue<Integer> queue1 ;
    Queue<Integer> queue2 ;
    int size;
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        size = 0;
    }

    public void push(int x) {
        size++;
        queue2.offer(x);
        if(size > 1){
            queue1.offer(queue2.poll());
        }
    }

    public int pop() {
        size--;
        int ans = queue2.poll();
        if(size > 0) {
            while(queue1.size() > 1){
                queue2.offer(queue1.poll());
            }
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }
        return ans;
    }

    public int top() {
        return queue2.peek();
    }

    public boolean empty() {
       return size == 0;
    }
}
