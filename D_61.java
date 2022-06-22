package com.fengtin.LeetCode;

public class D_61 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode ans = new ListNode();
        ListNode p = head;
        int length = 0;
        while (p != null){
            p = p.next;
            length++;
        }
        /**
         * 边界条件。
         */
        if(length == 1 || length == 0){
            return head;
        }
        int move = k % length;
        if(move == 0){
            return head;
        }
        p = head;
        while(length - move > 1){
            p = p.next;
            move++;
        }
        ListNode newHead = p.next;
        p.next = null;
        p = newHead;
        while(p.next != null){
            p = p.next;
        }
        p.next = head;
        return newHead;
    }
}
