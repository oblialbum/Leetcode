package com.fengtin.LeetCode;

public class D_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            }
            else{
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }
        }
        if(l1 == null){
            p .next = l2;
        }
        else{
            p.next = l1;
        }
        return head.next;
    }
}
