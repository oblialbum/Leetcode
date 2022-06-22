package com.fengtin.LeetCode;

public class MyCircularDeque {
    private class Node{
        int val;
        Node next;
        Node pre;
        public Node(int val){
            this.val = val;
        }
    }
    Node dummy,tail;
    int curSize = 0,maxSize;
    public MyCircularDeque(int k) {
        dummy = new Node(-1);
        tail = new Node(-1);
        dummy.next = tail;
        dummy.pre = tail;
        tail.pre = dummy;
        tail.next = dummy;
        maxSize = k;
    }

    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        Node cur = new Node(value);
        cur.next = dummy.next;
        cur.pre = dummy;
        dummy.next.pre = cur;
        dummy.next = cur;
        curSize++;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        Node cur = new Node(value);
        cur.next = tail;
        cur.pre = tail.pre;
        tail.pre.next = cur;
        tail.pre = cur;
        curSize++;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        dummy.next.next.pre = dummy;
        dummy.next = dummy.next.next;
        curSize--;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        tail.pre.pre.next = tail;
        tail.pre = tail.pre.pre;
        curSize--;
        return true;
    }

    public int getFront() {
        return dummy.next.val;
    }

    public int getRear() {
        return tail.pre.val;
    }

    public boolean isEmpty() {
        return curSize == 0;
    }

    public boolean isFull() {
        return curSize == maxSize;
    }

}
