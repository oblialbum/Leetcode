package com.fengtin.LeetCode;

public class D_2 {
    public static void main(String[] args) {
        D_2 d = new D_2();
        ListNode l1 = d.createNode(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = d.createNode(new int[]{9, 9, 9, 9});
        d.addTwoNumbers(l1, l2);
    }

    private ListNode createNode(int a[]) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for (int i = 0; i < a.length; i++) {
            p.next = new ListNode(a[i]);
            p = p.next;
        }
        return head.next;
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //进位
        int temp = 0;
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + temp;
            temp = val / 10;
            ListNode l3 = new ListNode(val % 10);
            l1 = l1.next;
            l2 = l2.next;
            p.next = l3;
            p = p.next;
        }
        if (l1 == null && l2 == null && temp > 0) {
            p.next = new ListNode(temp);
            return head.next;
        }
        if (l1 == null) {
            while (l2 != null) {
                l2.val += temp;
                temp = l2.val / 10;
                l2.val %= 10;
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
            if (temp > 0) {
                p.next = new ListNode(temp);
            }
        }
        if (l2 == null) {
            while (l1 != null) {
                l1.val += temp;
                temp = l1.val / 10;
                l1.val %= 10;

                p.next = l1;
                p = p.next;
                l1 = l1.next;
            }
            if (temp > 0) {
                p.next = new ListNode(temp);
            }
        }
        return head.next;
    }

}
