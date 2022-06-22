package com.fengtin.LeetCode;

public class D_206 {
    /**
     * 递归反转链表。
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 头插法
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode ans = new ListNode();
        ListNode p = head,pre = null,first = null;
        while (p != null){
            pre = p;
            p = p.next;
            pre.next = first;
            ans.next = pre;
            first = ans.next;
        }
        return ans.next;
    }

    /**
     * 迭代。
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = head,pre = null;
        while (p != null){
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }
}
