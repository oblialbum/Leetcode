package com.fengtin.LeetCode;

public class D_203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy,p = head;
        while(p != null){
            if(p.val == val){
                pre.next = p.next;
                p = p.next;
            }
            else{
                pre = p;
                p = p .next;
            }
        }
        return dummy.next;
    }
}
