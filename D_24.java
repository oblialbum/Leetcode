package com.fengtin.LeetCode;

public class D_24 {
    public ListNode swapPairs(ListNode head) {
        /**
         * 仅有0/1个元素，无需处理，直接返回。
         */
        if(head == null || head.next == null){
            return head;
        }
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode pre = head;
        ListNode p = head.next;
        /**
         * head要重新指向第一个节点，原来的指向第二个节点了。
         */
        head = head.next;
        /**
         * 当前一组几点处理完毕之后，p,pre仍指向相同 位置 的节点。
         * p之后没有两个节点时，返回。
         * 还需要一个指针指向pre之前的元素。
         */
        while (true){
            root.next = p;
            pre.next = p.next;
            p.next = pre;

            if(pre.next != null && pre.next.next != null) {
                root = pre;
                pre = pre.next;
                p = pre.next;
            }
            else{
                break;
            }
        }
        return head;
    }
}
