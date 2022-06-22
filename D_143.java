package com.fengtin.LeetCode;

public class D_143 {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        ListNode slow = head,fast = head.next;
        /**
         * 节点数：1.奇，2.偶。
         * 1.slow指向前半部分最后一个，fast指向最后一个。
         * 2.slow指向中间一个，fast指向null。
         */
        while(fast != null){
            if(fast.next != null){
                fast = fast.next.next;
            }
            else{
                break;
            }
            slow = slow.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        /**
         * 反转second链表，再将其插入head链表中。
         */
        fast = reverse(second);
        slow = head;
        while (slow !=null && fast != null){
            ListNode p1 = slow.next,p2 = fast.next;
            slow.next = fast;
            fast.next = p1;
            slow = p1;
            fast = p2;
        }
    }

    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        new D_143().reorderList(head);
    }
}
