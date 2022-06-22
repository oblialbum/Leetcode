package com.fengtin.LeetCode;

/**
 * @author 王鑫
 * FIFO:在队头插入，在队尾删除。
 * dummy:头节点
 * tail:尾节点。
 */
public class MyCircularQueue {
    int maxSize;
    int curSize;
    ListNode dummy = new ListNode(0),tail = new ListNode(0);
    public MyCircularQueue(int k) {
        maxSize = k;
        curSize = 0;
        dummy.next = tail;
        dummy.prev = tail;
        tail.prev = dummy;
        tail.next = dummy;
    }

    public boolean enQueue(int value) {
        if(this.isFull()){
            return false;
        }
        ListNode head = new ListNode(value);
        head.next = dummy.next;
        dummy.next.prev = head;
        head.prev = dummy;
        dummy.next = head;
        curSize++;
        return true;
    }

    public boolean deQueue() {
        if(this.isEmpty()){
            return false;
        }
        ListNode pre = tail.prev.prev;
        tail.prev = pre;
        pre.next = tail;
        curSize--;
        return true;
    }

    public int Front() {
        return curSize == 0 ? -1:tail.prev.val;
    }

    public int Rear() {
        return curSize == 0 ? -1 :dummy.next.val;
    }

    public boolean isEmpty() {
        return curSize == 0;
    }

    public boolean isFull() {
        return curSize == maxSize;
    }
    class ListNode{
        int val;
        ListNode next;
        ListNode prev;
        public ListNode (int val){
            this.val = val;
        }
    }
}
