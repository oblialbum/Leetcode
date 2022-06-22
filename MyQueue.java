package com.fengtin.LeetCode;

import java.util.Stack;

/**
 * @author 王鑫
 */
public class MyQueue {
    /**
     * implement by two Stack.
     */
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int size;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        size = 0;
    }

    public void push(int x) {
        size++;
        stack2.push(x);
    }

    public int pop() {
        if(this.empty()){
            return -1;
        }
        size--;
        if(stack1.isEmpty()){
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
        return stack1.pop();
    }

    public int peek() {
        if(this.empty()){
            return -1;
        }
        if(stack1.isEmpty()){
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
        return stack1.peek();
    }

    public boolean empty() {
        return size == 0;
    }
}
