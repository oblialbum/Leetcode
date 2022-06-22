package com.fengtin.LeetCode;

public class D_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode ans = new ListNode(-1);
        ListNode pre = ans;
        ans.next = head;
        int cur = head.val;
        int count = 1;
        while (head.next != null){
            if(head.next.val == cur){
                head = head.next;
                count++;
                continue;
            }
            if(count == 1){
                pre.next = head;
                pre = pre.next;
                head = head.next;
                cur = head.val;
            }
            /**
             * 此时，head指向当前相同元素的最后一个。
             */
            else{
                head = head.next;
                cur = head.val;
                count = 1;
            }
        }
        /**
         * 最后一组元素未处理。
         */
        if(count == 1){
            pre.next = head;
        }
        else{
            pre.next = null;
        }
        return ans.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        new D_82().deleteDuplicates(head);
    }
}
