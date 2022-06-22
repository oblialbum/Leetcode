package com.fengtin.LeetCode;

public class D_141 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head,fast = head.next;
        while(slow != null && fast != null){
            if(slow == fast){
                return true;
            }
            slow = slow.next;
            if(fast.next != null){
                fast = fast.next.next;
            }
            else{
                return false;
            }
        }
        return false;
    }
}
