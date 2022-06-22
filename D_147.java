package com.fengtin.LeetCode;

public class D_147 {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return  head;
        }
        ListNode ans = new ListNode(),pre,p;
        ans.next = head;
        ListNode next = head.next,lastSorted = ans.next;
        head.next = null;
        head = next;
        while(head != null){
            next = head.next;
            if(head.val < lastSorted.val) {
                pre = ans;
                p = ans.next;
                while (p != null && head.val > p.val) {
                    pre = p;
                    p = p.next;
                }
                pre.next = head;
                head.next = p;
                if(p == null){
                    lastSorted = p;
                }
            }
            else{
               lastSorted .next = head;
                head.next = null;
               lastSorted = lastSorted.next;
            }

            head = next;
        }
        return ans.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        new D_147().insertionSortList(head);
    }
}
