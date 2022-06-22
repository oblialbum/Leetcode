package com.fengtin.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 王鑫
 */
public class MinStack {
    class DNode{
        int val;
        DNode prev;
        DNode next;
        public DNode (int value){
            this.val = value;
        }
    }
    private DNode dummy = new DNode(0),tail = new DNode(0);
    PriorityQueue<DNode> minHeap = new PriorityQueue<>(new Comparator<DNode>(){

        @Override
        public int compare(DNode o1, DNode o2) {
            return o1.val > o2.val? 1 :-1;
        }
    });
    public MinStack() {
        dummy.next = tail;
        dummy.prev = tail;
        tail.next = dummy;
        tail.prev = dummy;
    }

    public void push(int val) {
        DNode head = new DNode(val);
        head.next = dummy.next;
        head.prev = dummy;
        dummy.next = head;
        head.next.prev = head;

        minHeap.add(head);

    }

    public void pop() {
        dummy.next.next.prev = dummy;
        dummy.next = dummy.next.next;

        minHeap.remove(minHeap.peek());
    }

    public int top() {
        return dummy.next.val;
    }

    public int getMin() {
        return minHeap.peek().val;
    }
}
