package com.fengtin.LeetCode;

public class D_234 {
    public boolean isPalindrome(ListNode head) {
        if(head.next == null){
            return true;
        }
        ListNode mid = getMid(head);
        ListNode second = reverseList(mid.next);
        ListNode first = head;
        while(second != null){
            if(first.val != second.val){
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }

    /**
     * 至少有俩个节点。
     * @param head
     * @return 奇数时，返回中间一个节点。偶数时，返回中间靠左的节点。
     */
    private ListNode getMid(ListNode head) {
        ListNode slow = head,fast = head.next;
        while(fast != null){
            if(fast.next != null){
                fast = fast.next.next;
            }
            else{
                break;
            }
            slow = slow.next;
        }
        return slow;
    }
}
