package com.fengtin.LeetCode;

public class D_142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head,fast = head.next;
        while(slow != null && fast != null){
            if(slow == fast){
                /*
                fast走过的路程是slow的二倍。
                */
                ListNode ans = head;
                slow = slow.next;
                while(ans != slow ){
                    ans = ans.next;
                    slow = slow.next;
                }
                return ans;
            }
            slow = slow.next;
            if(fast.next != null){
                fast = fast.next.next;
            }
            else{
                return null;
            }
        }
        return null;
    }
}
