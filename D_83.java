package com.fengtin.LeetCode;

public class D_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = head;
        int cur = head.val;
        while(p.next != null){
            if(cur != p.next.val){
                p = p.next;
                cur = p.val;
            }
            else{
                p.next = p.next.next;
            }
        }
        return head;
    }
}
